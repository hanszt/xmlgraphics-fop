/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/* $Id$ */

package org.apache.fop.event;

import java.util.Locale;

import org.xml.sax.Locator;

import org.apache.fop.events.Event;
import org.apache.fop.events.EventExceptionManager.ExceptionFactory;
import org.apache.fop.events.EventFormatter;
import org.apache.fop.fo.ValidationException;

/**
 * Exception factory for {@link ValidationException}.
 */
public class ValidationExceptionFactory implements ExceptionFactory {

    /** {@inheritDoc} */
    public Throwable createException(Event event) {
        Locator loc = (Locator)event.getParam("loc");
        String msg = EventFormatter.format(event, Locale.ENGLISH);
        ValidationException ex = new ValidationException(msg, loc);
        if (!Locale.ENGLISH.equals(Locale.getDefault())) {
            ex.setLocalizedMessage(EventFormatter.format(event));
        }
        return ex;
    }

    /** {@inheritDoc} */
    public Class<ValidationException> getExceptionClass() {
        return ValidationException.class;
    }


}
