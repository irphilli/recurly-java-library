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

public class TestInvoiceCollection2 extends TestModelBase {

    @Test(groups = "fast")
    public void testDeserialization() throws Exception {
        // See https://dev.recurly.com/docs/list-invoices
        final String invoicesData = 
         "<invoice_collection>" +
         "        <charge_invoice/>" +
         "        <credit_invoices type=\"array\">" +
         "            <credit_invoice href=\"\">" +
         "                <account href=\"https://experts-test2.recurly.com/v2/accounts/1382941\"/>" +
         "                <address>" +
         "                    <address1 nil=\"nil\"></address1>" +
         "                    <address2 nil=\"nil\"></address2>" +
         "                    <city nil=\"nil\"></city>" +
         "                    <state nil=\"nil\"></state>" +
         "                    <zip nil=\"nil\"></zip>" +
         "                    <country nil=\"nil\"></country>" +
         "                    <phone nil=\"nil\"></phone>" +
         "                </address>" +
         "                <uuid>4564786a6c2a0f02466a4b4d4abb0301</uuid>" +
         "                <state>open</state>" +
         "                <invoice_number_prefix></invoice_number_prefix>" +
         "                <invoice_number nil=\"nil\"></invoice_number>" +
         "                <vat_number nil=\"nil\"></vat_number>" +
         "                <tax_in_cents type=\"integer\">0</tax_in_cents>" +
         "                <total_in_cents type=\"integer\">-24989</total_in_cents>" +
         "                <currency>USD</currency>" +
         "                <created_at nil=\"nil\"></created_at>" +
         "                <updated_at nil=\"nil\"></updated_at>" +
         "                <attempt_next_collection_at nil=\"nil\"></attempt_next_collection_at>" +
         "                <closed_at nil=\"nil\"></closed_at>" +
         "                <customer_notes nil=\"nil\"></customer_notes>" +
         "                <recovery_reason nil=\"nil\"></recovery_reason>" +
         "                <subtotal_before_discount_in_cents type=\"integer\">-24989</subtotal_before_discount_in_cents>" +
         "                <subtotal_in_cents type=\"integer\">-24989</subtotal_in_cents>" +
         "                <discount_in_cents type=\"integer\">0</discount_in_cents>" +
         "                <due_on nil=\"nil\"></due_on>" +
         "                <balance_in_cents type=\"integer\">-24989</balance_in_cents>" +
         "                <type>credit</type>" +
         "                <origin>immediate_change</origin>" +
         "                <credit_payments type=\"array\">" +
         "                </credit_payments>" +
         "                <net_terms nil=\"nil\"></net_terms>" +
         "                <collection_method nil=\"nil\"></collection_method>" +
         "                <po_number nil=\"nil\"></po_number>" +
         "                <terms_and_conditions nil=\"nil\"></terms_and_conditions>" +
         "                <line_items type=\"array\">" +
         "                    <adjustment href=\"\" type=\"credit\">" +
         "                        <account href=\"https://experts-test2.recurly.com/v2/accounts/1382941\"/>" +
         "                        <uuid>4564786a5397bc3066c9ec47579ed871</uuid>" +
         "                        <state>pending</state>" +
         "                        <description>Premium Pro Annual</description>" +
         "                        <accounting_code nil=\"nil\"></accounting_code>" +
         "                        <product_code>premium_annually_2018</product_code>" +
         "                        <origin>plan</origin>" +
         "                        <unit_amount_in_cents type=\"integer\">-24989</unit_amount_in_cents>" +
         "                        <quantity type=\"integer\">1</quantity>" +
         "                        <quantity_remaining type=\"integer\">1</quantity_remaining>" +
         "                        <original_adjustment_uuid>4564036d05e333f5fbce49401a831bd7</original_adjustment_uuid>" +
         "                        <discount_in_cents type=\"integer\">0</discount_in_cents>" +
         "                        <tax_in_cents type=\"integer\">0</tax_in_cents>" +
         "                        <total_in_cents type=\"integer\">-24989</total_in_cents>" +
         "                        <currency>USD</currency>" +
         "                        <proration_rate type=\"float\">0.9998</proration_rate>" +
         "                        <taxable type=\"boolean\">false</taxable>" +
         "                        <start_date type=\"datetime\">2018-06-12T20:25:56Z</start_date>" +
         "                        <end_date type=\"datetime\">2019-06-12T18:18:09Z</end_date>" +
         "                        <created_at nil=\"nil\"></created_at>" +
         "                        <updated_at nil=\"nil\"></updated_at>" +
         "                        <revenue_schedule_type>evenly</revenue_schedule_type>" +
         "                        <credit_reason_code>refund</credit_reason_code>" +
         "                    </adjustment>" +
         "                </line_items>" +
         "                <transactions type=\"array\">" +
         "                </transactions>" +
         "            </credit_invoice>" +
         "        </credit_invoices>" +
         "    </invoice_collection>";

        final InvoiceCollection invoiceCollection = xmlMapper.readValue(invoicesData, InvoiceCollection.class);
        System.out.println("!!!!!" + invoiceCollection.getChargeInvoice());
        System.out.println("!!!!!" + invoiceCollection.getCreditInvoices());

    }
}
