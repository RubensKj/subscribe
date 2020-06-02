package com.rubenskj.core;

import com.rubenskj.core.handlers.Invoice;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Invoice invoice = new Invoice();

        invoice.produce();
    }
}
