package core;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HTML {
    private PrintWriter writer;

    public HTML(File file) {
        try {
            this.writer = new PrintWriter(new FileWriter(file, true));
            String timeStamp = new SimpleDateFormat("HH:mm:ss      dd/MM/yyyy").format(Calendar.getInstance().getTime());
            writer.println("<style>\n" +
                    "table {\n" +
                    "    font-family: arial, sans-serif;\n" +
                    "    border-collapse: collapse;\n" +
                    "    width: 100%;\n" +
                    "}\n" +
                    "\n" +
                    "td, th {\n" +
                    "    border: 1px solid #dddddd;\n" +
                    "    text-align: left;\n" +
                    "    padding: 8px;\n" +
                    "}\n" +
                    "\n" +
                    "tr:nth-child(even) {\n" +
                    "    background-color: #dddddd;\n" +
                    "}\n" +
                    "</style>");

            writer.println("<table>");
            writer.println("<tr>" + timeStamp + "</tr>");
            writer.println("<tr><th>Time</th><th>TestSuite</th><th>TestCase</th><th>Status</th></tr>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(String suiteName, String testName, String testResults) {
        String time = new SimpleDateFormat("HH:mm:ss      dd/MM/yyyy").format(Calendar.getInstance().getTime());
        writer.println("<tr><th>" + time + "</th>");
        writer.println("<th>" + suiteName + "</th>");

        writer.println("<th>" + testName + "</th>");
        if (testResults.equals("PASS"))
            writer.println("<th style=\"color: green;\">" + testResults + "</th></tr>");
        else {
            if (testResults.equals("FAIL"))
                writer.println("<th style=\"color: red;\">" + testResults + "</th></tr>");
            else writer.println("<th>" + testResults + "</th></tr>");
        }
        writer.flush();

    }
}



