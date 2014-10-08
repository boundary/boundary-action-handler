package com.boundary.sdk.action;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class ServletActionProcessor {

public void process(Exchange exchange) throws Exception {
        String contentType = exchange.getIn().getHeader(Exchange.CONTENT_TYPE, String.class);
        String path = exchange.getIn().getHeader(Exchange.HTTP_URI, String.class);
        path = path.substring(path.lastIndexOf("/"));
 
        //assertEquals("Get a wrong content type", CONTENT_TYPE, contentType);
        // assert camel http header
        String charsetEncoding = exchange.getIn().getHeader(Exchange.HTTP_CHARACTER_ENCODING, String.class);
        //assertEquals("Get a wrong charset name from the message heaer", "UTF-8", charsetEncoding);
        // assert exchange charset
        //assertEquals("Get a wrong charset naem from the exchange property", "UTF-8", exchange.getProperty(Exchange.CHARSET_NAME));
        exchange.getOut().setHeader(Exchange.CONTENT_TYPE, contentType + "; charset=UTF-8");
        exchange.getOut().setHeader("PATH", path);
        exchange.getOut().setBody("<b>Hello World</b>");
    }

}
