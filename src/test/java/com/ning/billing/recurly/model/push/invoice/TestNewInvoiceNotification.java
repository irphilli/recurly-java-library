/*
 * Copyright 2010-2013 Ning, Inc.
 *
 * Ning licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.ning.billing.recurly.model.push.invoice;

import com.ning.billing.recurly.model.TestModelBase;
import com.ning.billing.recurly.model.push.Notification;
import org.testng.Assert;
import org.testng.annotations.Test;

// See http://docs.recurly.com/api/push-notifications
public class TestNewInvoiceNotification extends TestModelBase {

    @Test(groups = "fast")
    public void testDeserialization() throws Exception {
        final String voidData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                                "<new_invoice_notification>\n" +
                                "  <account>\n" +
                                "    <account_code>1</account_code>\n" +
                                "    <username nil=\"true\"></username>\n" +
                                "    <email>verena@example.com</email>\n" +
                                "    <first_name>Verana</first_name>\n" +
                                "    <last_name>Example</last_name>\n" +
                                "    <company_name nil=\"true\"></company_name>\n" +
                                "  </account>\n" +
                                "  <invoice>\n" +
                                "    <uuid>ffc64d71d4b5404e93f13aac9c63b007</uuid>\n" +
                                "    <subscription_id>444a710bad5f4dddd4a4ac49fb98ad63</subscription_id>\n" +
                                "    <subscription_ids type=\"array\">\n" +
                                "      <subscription_id>444a710bad5f4dddd4a4ac49fb98ad63</subscription_id>\n" +
                                "    </subscription_ids>\n" +
                                "    <state>open</state>\n" +
                                "    <invoice_number_prefix></invoice_number_prefix>\n" +
                                "    <invoice_number type=\"integer\">1000</invoice_number>\n" +
                                "    <po_number>abcd</po_number>\n" +
                                "    <vat_number></vat_number>\n" +
                                "    <total_in_cents type=\"integer\">1000</total_in_cents>\n" +
                                "    <currency>USD</currency>\n" +
                                "    <date type=\"dateTime\">2014-01-01T20:21:44Z</date>\n" +
                                "    <closed_at type=\"dateTime\" nil=\"true\"></closed_at>\n" +
                                "    <net_terms type=\"integer\">0</net_terms>\n" +
                                "    <collection_method>automatic</collection_method>\n" +
                                "  </invoice>\n" +
                                "</new_invoice_notification>";

        Notification.Type detected = Notification.detect(voidData);
        Assert.assertEquals(detected.getJavaType(), NewInvoiceNotification.class);

        final NewInvoiceNotification notification = Notification.read(voidData, NewInvoiceNotification.class);
        Assert.assertNotNull(notification);

        PushInvoice invoice = notification.getInvoice();
        Assert.assertEquals(invoice.getSubscriptionId(), "444a710bad5f4dddd4a4ac49fb98ad63");
        Assert.assertEquals(invoice.getSubscriptionIds().get(0), "444a710bad5f4dddd4a4ac49fb98ad63");
    }

}
