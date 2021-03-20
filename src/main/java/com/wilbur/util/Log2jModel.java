package com.wilbur.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log2jModel
{
    private static final Logger LOGGER = LogManager.getLogger(Log2jModel.class.getName());

    public static void main(String[] args)
    {
        LOGGER.debug("Debug Message Logged !!!");
        LOGGER.info("Info Message Logged !!!");
        LOGGER.error("Error Message Logged !!!", new NullPointerException("NullError"));
        LOGGER.warn("WARN Message Logged !!!");
        LOGGER.fatal("Fatal Message Logged !!!");
    }
}
