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
            writer.println("<tr><th>StartTime</th><th>Duration</th><th>TestSuite</th><th>TestCase</th><th>Status</th></tr>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(String duration, String suiteName, String testName, String testResults) {
        String time = new SimpleDateFormat("HH:mm:ss      dd/MM/yyyy").format(Calendar.getInstance().getTime());
        writer.println("<tr><td>" + time + "</td>");
        writer.println("<td>" + duration + "</td>");
        writer.println("<td>" + suiteName + "</td>");
        writer.println("<td>" + testName + "</td>");
        if (testResults.equals("PASS"))
            writer.println("<td style=\"color: green;\">" + testResults + "</td></tr>");
        else {
            if (testResults.equals("FAIL"))
                writer.println("<td style=\"color: red;\">" + testResults + "</td></tr>");
            else writer.println("<td>" + testResults + "</td></tr>");
        }
        writer.flush();

    }
}



