package com.bmtech.pushmessage.utils;
import java.io.File;  
import java.io.IOException;  
import java.net.InetAddress;  
import java.net.InetSocketAddress;  
  

import org.apache.mina.core.service.IoAcceptor;  
import org.apache.mina.core.service.IoServiceStatistics;  
import org.apache.mina.core.session.IdleStatus;  
import org.apache.mina.core.session.IoSession;  
import org.apache.mina.filter.codec.ProtocolCodecFilter;  
import org.apache.mina.filter.codec.demux.DemuxingProtocolDecoder;  
import org.apache.mina.filter.codec.demux.DemuxingProtocolEncoder;  
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;  
import org.dna.mqtt.moquette.messaging.spi.impl.SimpleMessaging;  
import org.dna.mqtt.moquette.proto.ConnAckEncoder;  
import org.dna.mqtt.moquette.proto.ConnectDecoder;  
import org.dna.mqtt.moquette.proto.DisconnectDecoder;  
import org.dna.mqtt.moquette.proto.DisconnectEncoder;  
import org.dna.mqtt.moquette.proto.MQTTLoggingFilter;  
import org.dna.mqtt.moquette.proto.PingReqDecoder;  
import org.dna.mqtt.moquette.proto.PingRespEncoder;  
import org.dna.mqtt.moquette.proto.PubAckDecoder;  
import org.dna.mqtt.moquette.proto.PubAckEncoder;  
import org.dna.mqtt.moquette.proto.PubCompDecoder;  
import org.dna.mqtt.moquette.proto.PubCompEncoder;  
import org.dna.mqtt.moquette.proto.PubCompMessage;  
import org.dna.mqtt.moquette.proto.PubRecDecoder;  
import org.dna.mqtt.moquette.proto.PubRecEncoder;  
import org.dna.mqtt.moquette.proto.PubRelDecoder;  
import org.dna.mqtt.moquette.proto.PubRelEncoder;  
import org.dna.mqtt.moquette.proto.PublishDecoder;  
import org.dna.mqtt.moquette.proto.PublishEncoder;  
import org.dna.mqtt.moquette.proto.SubAckEncoder;  
import org.dna.mqtt.moquette.proto.SubscribeDecoder;  
import org.dna.mqtt.moquette.proto.UnsubAckEncoder;  
import org.dna.mqtt.moquette.proto.UnsubscribeDecoder;  
import org.dna.mqtt.moquette.proto.messages.ConnAckMessage;  
import org.dna.mqtt.moquette.proto.messages.DisconnectMessage;  
import org.dna.mqtt.moquette.proto.messages.PingRespMessage;  
import org.dna.mqtt.moquette.proto.messages.PubAckMessage;  
import org.dna.mqtt.moquette.proto.messages.PubRecMessage;  
import org.dna.mqtt.moquette.proto.messages.PubRelMessage;  
import org.dna.mqtt.moquette.proto.messages.PublishMessage;  
import org.dna.mqtt.moquette.proto.messages.SubAckMessage;  
import org.dna.mqtt.moquette.proto.messages.UnsubAckMessage;  
import org.dna.mqtt.moquette.server.MQTTHandler;  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  

import com.bmtech.pushmessage.global.Contants;
public class MQTTBrokerProxyServer {
	private static final Logger LOG = LoggerFactory.getLogger(MQTTBrokerProxyServer.class);  
//	public static final String STORAGE_FILE_PATH = 
//		System.getProperty("user.home") + File.separator + "moquette_store.hawtdb";
	private IoAcceptor m_acceptor;  
    SimpleMessaging messaging;  

//    public static void main(String[] args)  
//      throws IOException  
//    {  
//    	System.out.println(123);
//      new MQTTBrokerProxyServer().startServer();  
//    }  

    public void startServer() throws IOException  
    {  
      //����Э���������  
      DemuxingProtocolDecoder decoder = new DemuxingProtocolDecoder();  
      decoder.addMessageDecoder(new ConnectDecoder());//���ӱ���  
      decoder.addMessageDecoder(new PublishDecoder());//��������  
      decoder.addMessageDecoder(new PubAckDecoder());//������ִ����  
      decoder.addMessageDecoder(new PubRelDecoder());  
      decoder.addMessageDecoder(new PubRecDecoder());//���ձ���  
      decoder.addMessageDecoder(new PubCompDecoder());  
      decoder.addMessageDecoder(new SubscribeDecoder());//���ı���  
      decoder.addMessageDecoder(new UnsubscribeDecoder());//ȡ�����ı���  
      decoder.addMessageDecoder(new DisconnectDecoder());//�Ͽ����ӱ���  
      decoder.addMessageDecoder(new PingReqDecoder());//����ping�������  
        
      //����Э���������  
      DemuxingProtocolEncoder encoder = new DemuxingProtocolEncoder();  

      encoder.addMessageEncoder(ConnAckMessage.class, new ConnAckEncoder());//���ӽ���  
      encoder.addMessageEncoder(SubAckMessage.class, new SubAckEncoder());//����֪ͨ����  
      encoder.addMessageEncoder(UnsubAckMessage.class, new UnsubAckEncoder());//ȡ�����Ľ���  
      encoder.addMessageEncoder(PubAckMessage.class, new PubAckEncoder());//������ִ����  
      encoder.addMessageEncoder(PubRecMessage.class, new PubRecEncoder());//���ս���  
      encoder.addMessageEncoder(PubCompMessage.class, new PubCompEncoder());  
      encoder.addMessageEncoder(PubRelMessage.class, new PubRelEncoder());  
      encoder.addMessageEncoder(PublishMessage.class, new PublishEncoder());//��������  
      encoder.addMessageEncoder(PingRespMessage.class, new PingRespEncoder());//����ping��Ӧ����  
      encoder.addMessageEncoder(DisconnectMessage.class,new DisconnectEncoder());//�Ͽ����ӽ���  
        
      this.m_acceptor = new NioSocketAcceptor();  
      //������־�Ĺ�����  
      this.m_acceptor.getFilterChain().addLast("logger", new MQTTLoggingFilter("SERVER LOG"));  
      //���ñ���Ĺ�����  
      this.m_acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(encoder, decoder));  
      //����ҵ��������  
      MQTTHandler handler = new MQTTHandler();  
      //����һ��������Ϣ�����Ϣ  
      this.messaging = SimpleMessaging.getInstance();  
      this.messaging.init();  
      //������Ϣ��  
      handler.setMessaging(this.messaging);  
      //����ҵ��������  
      this.m_acceptor.setHandler(handler);  
        
      ((NioSocketAcceptor)this.m_acceptor).setReuseAddress(true);  
      ((NioSocketAcceptor)this.m_acceptor).getSessionConfig().setReuseAddress(true);  
      this.m_acceptor.getSessionConfig().setReadBufferSize(2048);  
      this.m_acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);  
      this.m_acceptor.getStatistics().setThroughputCalculationInterval(10);  
      this.m_acceptor.getStatistics().updateThroughput(System.currentTimeMillis());  
      //���ö˿ں�  
      this.m_acceptor.bind(new InetSocketAddress(Contants.port));  
      //��ȡ�󶨵ı��ص�ip��ַ   
      LOG.info("Server binded"+InetAddress.getLocalHost().getHostAddress());  
//      try {  
//          Thread.sleep(10000);  
//      } catch (InterruptedException e) {  
//          // TODO Auto-generated catch block  
//          e.printStackTrace();  
//      }  
//      //����broker����ĸ�����Ϣ  
//      Runtime.getRuntime().addShutdownHook(new Thread()  
//      {  
//        public void run() {  
//            MQTTBrokerProxyServer.this.stopServer();  
//        }  
//      });
    }  

    public void stopServer(){
      //����broker����ĸ�����Ϣ  
      Runtime.getRuntime().addShutdownHook(new Thread()  
      {  
        public void run() {  
            stopServer1();  
        }  
      });
    }
    public void stopServer1() {  
      LOG.info("Server stopping...");  
        
      this.messaging.stop();  
      //Mina  IO ͳ����  
      IoServiceStatistics statistics = this.m_acceptor.getStatistics();  
      statistics.updateThroughput(System.currentTimeMillis());  
      System.out.println(String.format("Total read bytes: %d, read throughtput: %f (b/s)", new Object[] { Long.valueOf(statistics.getReadBytes()), Double.valueOf(statistics.getReadBytesThroughput()) }));  
      System.out.println(String.format("Total read msgs: %d, read msg throughtput: %f (msg/s)", new Object[] { Long.valueOf(statistics.getReadMessages()), Double.valueOf(statistics.getReadMessagesThroughput()) }));  
      //�ر���صĻỰ  
      for (IoSession session : this.m_acceptor.getManagedSessions().values()) {  
        if ((session.isConnected()) && (!session.isClosing())) {  
          session.close(false);  
        }  
      }  
      //���ٱ���IoAcceptor����  
      this.m_acceptor.unbind();  
      this.m_acceptor.dispose();  
      LOG.info("Server stopped");  
    }  
  }  
