package com.google.inject.spi;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

import java.lang.Exception;

/**
 * Tests for {@link Message}.
 */
public class MessageTest extends TestCase {

  public void testMessageHashCodeVariesWithSource() {
    String innerMessage = "This is the message.";
    Exception throwable = new Exception(innerMessage);
    Message firstMessage = new Message(1, innerMessage);
    Message secondMessage = new Message(2, innerMessage);
    assertFalse(firstMessage.hashCode() == secondMessage.hashCode());
  }

  public void testMessageHashCodeVariesWithCause() {
    String innerMessage = "This is the message.";
    List<Object> sourceList = new ArrayList<Object>();
    sourceList.add(new Object());
    Exception firstThrowable = new Exception(innerMessage);
    Exception secondThrowable = new Exception(innerMessage);
    Message firstMessage = new Message(sourceList, innerMessage, firstThrowable);
    Message secondMessage = new Message(sourceList, innerMessage, secondThrowable);
    assertFalse(firstMessage.hashCode() == secondMessage.hashCode());
  }
}

