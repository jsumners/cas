/*
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.cas.ticket.registry.support.kryo.serial;

import java.nio.ByteBuffer;

import com.esotericsoftware.kryo.serialize.SimpleSerializer;
import org.jasig.cas.ticket.registry.support.kryo.FieldHelper;
import org.jasig.cas.ticket.support.MultiTimeUseOrTimeoutExpirationPolicy;

/**
 * Serializer for {@link MultiTimeUseOrTimeoutExpirationPolicy}.
 *
 * @author Marvin S. Addison
 */
public final class MultiTimeUseOrTimeoutExpirationPolicySerializer extends
            SimpleSerializer<MultiTimeUseOrTimeoutExpirationPolicy> {

    /** FieldHelper instance. **/
    protected final FieldHelper fieldHelper;

    public MultiTimeUseOrTimeoutExpirationPolicySerializer(final FieldHelper helper) {
        this.fieldHelper = helper;
    }

    public void write(final ByteBuffer buffer, final MultiTimeUseOrTimeoutExpirationPolicy policy) {
        buffer.putInt((Integer) fieldHelper.getFieldValue(policy, "numberOfUses"));
        buffer.putLong((Long) fieldHelper.getFieldValue(policy, "timeToKillInMilliSeconds"));
    }

    public MultiTimeUseOrTimeoutExpirationPolicy read(final ByteBuffer buffer) {
        return new MultiTimeUseOrTimeoutExpirationPolicy(buffer.getInt(), buffer.getLong());
    }
}
