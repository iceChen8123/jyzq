package com.ice.jyzq.util;

import java.util.Properties;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class EncryptablePropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	public static final String JDBC_DATASOURCE_URL_KEY = "connection.url";

	public static final String JDBC_DATASOURCE_USERNAME_KEY = "connection.username";

	public static final String JDBC_DATASOURCE_PASSWORD_KEY = "connection.password";

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
			throws BeansException {
		String username = props.getProperty(JDBC_DATASOURCE_USERNAME_KEY);
		if (username != null) {
			props.setProperty(JDBC_DATASOURCE_USERNAME_KEY, decode(username));
		}

		String password = props.getProperty(JDBC_DATASOURCE_PASSWORD_KEY);
		if (password != null) {
			props.setProperty(JDBC_DATASOURCE_PASSWORD_KEY, decode(password));
		}

		String url = props.getProperty(JDBC_DATASOURCE_URL_KEY);
		if (url != null) {
			props.setProperty(JDBC_DATASOURCE_URL_KEY, decode(url));
		}
		super.processProperties(beanFactoryToProcess, props);

	}

	private static String decode(String aString) {
		try {
			return new String(EndecryptUtils.decryptBase64(new String(Hex.decodeHex(aString.toCharArray()))));
		} catch (DecoderException e) {
			e.printStackTrace();
		}
		return "";
	}
	

}
