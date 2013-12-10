/*
 * Copyright (C) 2013 KeithYokoma. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.arbalest.net.converter;

import com.arbalest.exception.ArbalestNetworkException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;

public class RawJsonConverter implements Converter {
    @Override
    public String convert(Object object) throws ArbalestNetworkException {
        return object.toString();
    }

    @Override
    public <T> void convert(OutputStream out, T object) throws ArbalestNetworkException {
        try {
            out.write(object.toString().getBytes());
        } catch (IOException e) {
            throw new ArbalestNetworkException(e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T convert(InputStream in, Type type) throws ArbalestNetworkException {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();

        try {
            String line = null;
            reader = new BufferedReader(new InputStreamReader(in));
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            return (T) builder.toString();
        } catch (IOException e) {
            throw new ArbalestNetworkException(e);
        }
    }
}