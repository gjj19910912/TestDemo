package com.bmtech.pushmessage.utils;

import com.ibm.mqtt.MqttClient;
import com.ibm.mqtt.MqttException;
import com.ibm.mqtt.MqttSimpleCallback;


public class MqttBroker {
//    private final static Log logger = LogFactory.getLog(MqttBroker.class);
    private final static String CONNECTION_STRING = "tcp://192.168.0.103:1883";
    private final static boolean CLEAN_START = true;
    private final static short KEEP_ALIVE = 30;
    private final static String CLIENT_ID = "648ba6374fbcaf26";
    private final static int[] QOS_VALUES = { 0, 0, 0, 2 };
    private final static String[] TOPICS = { "Test/TestTopics/Topic1",
            "Test/TestTopics/Topic2", "Test/TestTopics/Topic3",
            "tokudu/bbb" };
    private static MqttBroker instance = new MqttBroker();
 
    private MqttClient mqttClient;
 
    public static MqttBroker getInstance() {
        return instance;
    }
    public void connect() throws MqttException {
//        logger.info("connect to mqtt broker.");
        //���÷���˵�ip
        mqttClient = new MqttClient(CONNECTION_STRING);
        SimpleCallbackHandler simpleCallbackHandler = new SimpleCallbackHandler();
        mqttClient.registerSimpleHandler(simpleCallbackHandler);
        mqttClient.connect(CLIENT_ID, CLEAN_START, KEEP_ALIVE);
        mqttClient.publish("keepalive", "keepalive".getBytes(), QOS_VALUES[2],
                true);
    }
 
    public void sendMessage(String clientId, String message) {
        try {
            mqttClient.publish("tokudu/"+clientId, message.getBytes(),
                    0, false);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
     
    class SimpleCallbackHandler implements MqttSimpleCallback {
 
        public void connectionLost() throws Exception {
            System.out.println("�ͻ�����broker�Ѿ��Ͽ�");
            
//            stopKeepAlives();
//			// null itself
//			mConnection = null;
//			if (isNetworkAvailable() == true) {
//				reconnectIfNecessary();	
//			}
        }
 
        public void publishArrived(String topicName, byte[] payload, int Qos,
                boolean retained) throws Exception {
            // TODO Auto-generated method stub
            System.out.println("��������: " + topicName);
            System.out.println("��Ϣ����: " + new String(payload));
            System.out.println("��Ϣ����(0,1,2): " + Qos);
            System.out.println("�Ƿ���ʵʱ���͵���Ϣ(false=ʵʱ��true=�������ϱ����������Ϣ): " + retained);
        }
 
    }
 
//    public static void main(String[] args) {
//        MqttBroker mqttBroker = new MqttBroker();
//        try {
//            mqttBroker.connect();
//        } catch (MqttException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        Timer timer = new Timer();
//        TestTimerTask task = new TestTimerTask();
//        task.setMqttBroker(mqttBroker);
//        timer.schedule(task, 200L, 2000L);
//    }
    }
