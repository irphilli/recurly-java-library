/*
 * Copyright 2010-2014 Ning, Inc.
 * Copyright 2014-2015 The Billing Project, LLC
 *
 * The Billing Project licenses this file to you under the Apache License, version 2.0
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

package com.ning.billing.recurly.model;

import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestInvoiceCollection extends TestModelBase {

    @Test(groups = "fast")
    public void testDeserialization() throws Exception {
        // See https://dev.recurly.com/docs/list-invoices
        final String invoicesData = 
              "<invoice_collection>" +
              "        <charge_invoice href=\"\">" +
              "            <account href=\"https://experts-dev.recurly.com/v2/accounts/1349900\"/>" +
              "            <address>" +
              "                <address1 nil=\"nil\"></address1>" +
              "                <address2 nil=\"nil\"></address2>" +
              "                <city nil=\"nil\"></city>" +
              "                <state nil=\"nil\"></state>" +
              "                <zip nil=\"nil\"></zip>" +
              "                <country nil=\"nil\"></country>" +
              "                <phone nil=\"nil\"></phone>" +
              "            </address>" +
              "            <uuid>45647776054042f746f19a42fdaae418</uuid>" +
              "            <state>pending</state>" +
              "            <invoice_number_prefix></invoice_number_prefix>" +
              "            <invoice_number nil=\"nil\"></invoice_number>" +
              "            <vat_number nil=\"nil\"></vat_number>" +
              "            <tax_in_cents type=\"integer\">0</tax_in_cents>" +
              "            <total_in_cents type=\"integer\">0</total_in_cents>" +
              "            <currency>USD</currency>" +
              "            <created_at nil=\"nil\"></created_at>" +
              "            <updated_at nil=\"nil\"></updated_at>" +
              "            <attempt_next_collection_at type=\"datetime\">2018-06-12T20:24:54Z</attempt_next_collection_at>" +
              "            <closed_at nil=\"nil\"></closed_at>" +
              "            <customer_notes></customer_notes>" +
              "            <recovery_reason nil=\"nil\"></recovery_reason>" +
              "            <subtotal_before_discount_in_cents type=\"integer\">0</subtotal_before_discount_in_cents>" +
              "            <subtotal_in_cents type=\"integer\">-24988</subtotal_in_cents>" +
              "            <discount_in_cents type=\"integer\">0</discount_in_cents>" +
              "            <due_on type=\"datetime\">2018-06-12T20:24:54Z</due_on>" +
              "            <net_terms type=\"integer\">0</net_terms>" +
              "            <collection_method>automatic</collection_method>" +
              "            <po_number nil=\"nil\"></po_number>" +
              "            <terms_and_conditions></terms_and_conditions>" +
              "            <line_items type=\"array\">" +
              "                <adjustment href=\"\" type=\"credit\">" +
              "                    <account href=\"https://experts-dev.recurly.com/v2/accounts/1349900\"/>" +
              "                    <uuid>45647775e8d1cbeecfca0345ce94489e</uuid>" +
              "                    <state>pending</state>" +
              "                    <description>Credit for remaining Premium Pro Annual</description>" +
              "                    <accounting_code nil=\"nil\"></accounting_code>" +
              "                    <product_code>premium_annually_2018</product_code>" +
              "                    <origin>plan</origin>" +
              "                    <unit_amount_in_cents type=\"integer\">-24988</unit_amount_in_cents>" +
              "                    <quantity type=\"integer\">1</quantity>" +
              "                    <discount_in_cents type=\"integer\">0</discount_in_cents>" +
              "                    <tax_in_cents type=\"integer\">0</tax_in_cents>" +
              "                    <total_in_cents type=\"integer\">-24988</total_in_cents>" +
              "                    <currency>USD</currency>" +
              "                    <proration_rate type=\"float\">0.9997</proration_rate>" +
              "                    <taxable type=\"boolean\">false</taxable>" +
              "                    <start_date type=\"datetime\">2018-06-12T20:24:53Z</start_date>" +
              "                    <end_date type=\"datetime\">2019-06-12T17:58:25Z</end_date>" +
              "                    <created_at nil=\"nil\"></created_at>" +
              "                    <updated_at nil=\"nil\"></updated_at>" +
              "                    <revenue_schedule_type>evenly</revenue_schedule_type>" +
              "                </adjustment>" +
              "                <adjustment href=\"\" type=\"charge\">" +
              "                    <account href=\"https://experts-dev.recurly.com/v2/accounts/1349900\"/>" +
              "                    <uuid>456477761bf73d89cc12ed4935ba704f</uuid>" +
              "                    <state>pending</state>" +
              "                    <description>Account credit carried forward</description>" +
              "                    <accounting_code nil=\"nil\"></accounting_code>" +
              "                    <product_code nil=\"nil\"></product_code>" +
              "                    <origin>carryforward</origin>" +
              "                    <unit_amount_in_cents type=\"integer\">24988</unit_amount_in_cents>" +
              "                    <quantity type=\"integer\">1</quantity>" +
              "                    <discount_in_cents type=\"integer\">0</discount_in_cents>" +
              "                    <tax_in_cents type=\"integer\">0</tax_in_cents>" +
              "                    <total_in_cents type=\"integer\">24988</total_in_cents>" +
              "                    <currency>USD</currency>" +
              "                    <proration_rate nil=\"nil\"></proration_rate>" +
              "                    <taxable type=\"boolean\">false</taxable>" +
              "                    <start_date type=\"datetime\">2018-06-12T20:24:54Z</start_date>" +
              "                    <end_date nil=\"nil\"></end_date>" +
              "                    <created_at nil=\"nil\"></created_at>" +
              "                    <updated_at nil=\"nil\"></updated_at>" +
              "                    <revenue_schedule_type></revenue_schedule_type>" +
              "                </adjustment>" +
              "            </line_items>" +
              "            <transactions type=\"array\">" +
              "      </transactions>" +
              "        </charge_invoice>" +
              "        <credit_invoices type=\"array\">" +
              "    </credit_invoices>" +
              "    </invoice_collection>"; 

        final InvoiceCollection invoiceCollection = xmlMapper.readValue(invoicesData, InvoiceCollection.class);
        System.out.println("!!!!!" + invoiceCollection.getChargeInvoice());
        System.out.println("!!!!!" + invoiceCollection.getCreditInvoices());

    }
}
