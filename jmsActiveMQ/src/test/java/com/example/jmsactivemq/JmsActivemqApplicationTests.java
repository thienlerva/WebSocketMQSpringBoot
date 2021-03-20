package com.example.jmsactivemq;

import com.example.jmsactivemq.receiver.Receiver;
import com.example.jmsactivemq.sender.Sender;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

//@RunWith(SpringRunner.class)
@SpringBootTest
class JmsActivemqApplicationTests {

	@Autowired
	private Sender sender;

	@Autowired
	private Receiver receiver;

	@Test
	public void testReceive() throws Exception {
		sender.send("Hello Spring JMS ActiveMQ!");

		receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
		assertThat(receiver.getLatch().getCount()).isEqualTo(0);
	}

}
