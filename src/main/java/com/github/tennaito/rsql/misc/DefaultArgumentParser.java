/*
 * The MIT License
 *
 * Copyright 2013 Jakub Jirutka <jakub@jirutka.cz>.
 * Copyright 2015 Antonio Rabelo
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.tennaito.rsql.misc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Default implementation of {@linkplain ArgumentParser}. Supported types
 * are String, Integer, Long, Float, Boolean, Enum and Date. If neither one
 * of them match, it tries to invoke valueOf(String s) method via reflection on
 * the type's class.
 *
 * @author Jakub Jirutka <jakub@jirutka.cz>
 * @author AntonioRabelo
 */
public class DefaultArgumentParser implements ArgumentParser {

    private static final Logger LOG = Logger.getLogger(DefaultArgumentParser.class.getName());

    //ISO 8601
    private static final String DATE_PATTERN = "yyyy-MM-dd";

    //ISO 8601
    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";

    /* (non-Javadoc)
     * @see br.tennaito.rsql.misc.ArgumentParser#parse(java.lang.String, java.lang.Class)
     */
    public <T> T parse(String argument, Class<T> type) throws ArgumentFormatException, IllegalArgumentException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private <T> Date parseDate(String argument, Class<T> type) {
        try {
            return new SimpleDateFormat(DATE_TIME_PATTERN).parse(argument);
        } catch (ParseException ex) {
            LOG.log(Level.INFO, "Not a date time format, lets try with date format.");
        }
        try {
            return new SimpleDateFormat(DATE_PATTERN).parse(argument);
        } catch (ParseException ex1) {
            throw new ArgumentFormatException(argument, type);
        }
    }

    /* (non-Javadoc)
	 * @see br.tennaito.rsql.misc.ArgumentParser#parse(java.util.List, java.lang.Class)
	 */
    public <T> List<T> parse(List<String> arguments, Class<T> type) throws ArgumentFormatException, IllegalArgumentException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
