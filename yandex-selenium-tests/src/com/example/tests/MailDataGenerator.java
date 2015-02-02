package com.example.tests;
import com.thoughtworks.xstream.XStream;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.System.out;


/**
 * Created by yulia on 2/1/15.
 */
public class MailDataGenerator {
    public static void main(String[] args) throws IOException {
        if(args.length < 3)
        {
            out.println("Please, specify parameters: <amount of test data>, <file>, <format> ");
            return;
        }
        int amount = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        String format = args[2];

        List<MailData> mails = generateRandomMails(amount);
        if("csv".equals(format))
            saveMailsToCsvFile(mails, file);
        else if("xml".equals(format))
            saveMailsToXmlFile(mails, file);
        else {
            out.println("Unknown format" + format);
            return;
        }
    }

    private static void saveMailsToXmlFile(List<MailData> mails, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.alias("mail", MailData.class);
        String xml = xstream.toXML(mails);
        FileWriter writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    public static List<MailData> loadGroupsFromXmlFile(File file ) throws IOException {
        XStream xstream = new XStream();
        xstream.alias("mail", MailData.class);
        return (List<MailData>) xstream.fromXML(file);
    }

    private static void saveMailsToCsvFile(List<MailData> mails, File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        for (MailData mail : mails) {
            writer.write(mail.getRecipient() + "," + mail.getTopic() + "," + mail.getTopic() + "\n");
        }
        writer.close();
    }

    public static List<MailData> generateRandomMails(int amount) {
        List<MailData> list = new ArrayList<MailData>();
        Random rnd = new Random();
        String topic;
        String content;
        for (int i = 0; i < amount; i++) {
            topic = "" + rnd.nextInt();
            content = "" + rnd.nextInt();
            MailData mail = new MailData().withTopic(topic).withContent(content).withRecipient("testovajapochta1@rambler.ru");
            list.add(mail);
        }
        return list;
    }


    public static List<MailData> loadGroupsFromCsvFile(File file ) throws IOException {
        List<MailData> list = new ArrayList<MailData>();
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        while(line != null) {
            String[] part = line.split(",");
            MailData mail = new MailData().withRecipient(part[0]).withTopic(part[1]).withContent(part[2]);
            list.add(mail);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return list;
    }


}
