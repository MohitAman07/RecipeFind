package reports;

import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PDFReportGenerator {

    public static void generate(
            ITestContext context) {

        try {

            /*
             * Generate PDF Name With Date & Time
             */
            Date currentDate =
                    new Date();

            String timestamp =
                    new SimpleDateFormat(
                            "dd-MMM-yyyy_hh-mm-a")
                            .format(
                                    currentDate);

            String pdfPath =
                    "target/ExecutionReport_"
                            + timestamp
                            + ".pdf";

            /*
             * Create PDF
             */
            Document document =
                    new Document();

            PdfWriter.getInstance(
                    document,
                    new FileOutputStream(
                            pdfPath));

            document.open();

            Font titleFont =
                    FontFactory.getFont(
                            FontFactory.HELVETICA_BOLD,
                            20);

            Font headingFont =
                    FontFactory.getFont(
                            FontFactory.HELVETICA_BOLD,
                            14);

            Font normalFont =
                    FontFactory.getFont(
                            FontFactory.HELVETICA,
                            11);

            /*
             * Report Title
             */
            document.add(
                    new Paragraph(
                            "RecipeFind Automation Execution Report",
                            titleFont));

            document.add(
                    new Paragraph(" "));

            /*
             * Report Information
             */
            document.add(
                    new Paragraph(
                            "Execution Date : "
                                    + new SimpleDateFormat(
                                            "dd-MMM-yyyy")
                                            .format(
                                                    currentDate),
                            normalFont));

            document.add(
                    new Paragraph(
                            "Execution Time : "
                                    + new SimpleDateFormat(
                                            "hh:mm:ss a")
                                            .format(
                                                    currentDate),
                            normalFont));

            document.add(
                    new Paragraph(
                            "Framework : RecipeFind Mobile Automation",
                            normalFont));

            document.add(
                    new Paragraph(" "));

            /*
             * Execution Summary
             */
            int passed =
                    context.getPassedTests().size();

            int failed =
                    context.getFailedTests().size();

            int skipped =
                    context.getSkippedTests().size();

            int total =
                    passed + failed + skipped;

            document.add(
                    new Paragraph(
                            "Execution Summary",
                            headingFont));

            document.add(
                    new Paragraph(
                            "Passed  : " + passed,
                            normalFont));

            document.add(
                    new Paragraph(
                            "Failed  : " + failed,
                            normalFont));

            document.add(
                    new Paragraph(
                            "Skipped : " + skipped,
                            normalFont));

            document.add(
                    new Paragraph(
                            "Total   : " + total,
                            normalFont));

            document.add(
                    new Paragraph(" "));

            /*
             * Test Case Summary
             */
            PdfPTable table =
                    new PdfPTable(3);

            table.setWidthPercentage(
                    100);

            table.setWidths(
                    new float[] {
                            5,
                            2,
                            2
                    });

            PdfPCell header1 =
                    new PdfPCell(
                            new Paragraph(
                                    "Test Case",
                                    headingFont));

            PdfPCell header2 =
                    new PdfPCell(
                            new Paragraph(
                                    "Status",
                                    headingFont));

            PdfPCell header3 =
                    new PdfPCell(
                            new Paragraph(
                                    "Execution Time",
                                    headingFont));

            table.addCell(header1);
            table.addCell(header2);
            table.addCell(header3);

            /*
             * Passed Tests
             */
            for (ITestResult result :
                    context.getPassedTests().getAllResults()) {

                table.addCell(
                        result.getTestClass()
                                .getRealClass()
                                .getSimpleName());

                table.addCell(
                        "PASSED");

                table.addCell(
                        formatExecutionTime(
                                result));
            }

            /*
             * Failed Tests
             */
            for (ITestResult result :
                    context.getFailedTests().getAllResults()) {

                table.addCell(
                        result.getTestClass()
                                .getRealClass()
                                .getSimpleName());

                table.addCell(
                        "FAILED");

                table.addCell(
                        formatExecutionTime(
                                result));
            }

            /*
             * Skipped Tests
             */
            for (ITestResult result :
                    context.getSkippedTests().getAllResults()) {

                table.addCell(
                        result.getTestClass()
                                .getRealClass()
                                .getSimpleName());

                table.addCell(
                        "SKIPPED");

                table.addCell(
                        formatExecutionTime(
                                result));
            }

            document.add(
                    table);

            document.add(
                    new Paragraph(" "));

            document.add(
                    new Paragraph(
                            "Generated By : RecipeFind Mobile Automation Framework",
                            normalFont));

            document.close();

            System.out.println(
                    "==================================================");

            System.out.println(
                    "PDF Report Generated Successfully.");

            System.out.println(
                    "Location : "
                            + pdfPath);

            System.out.println(
                    "==================================================");
        }

        catch (Exception e) {

            e.printStackTrace();
        }
    }

    /*
     * Format Test Execution Time
     */
    private static String formatExecutionTime(
            ITestResult result) {

        long duration =
                result.getEndMillis()
                        - result.getStartMillis();

        if (duration < 1000) {

            return duration + " ms";
        }

        if (duration < 60000) {

            return new DecimalFormat(
                    "0.00")
                    .format(
                            duration / 1000.0)
                    + " sec";
        }

        long minutes =
                duration / 60000;

        long seconds =
                (duration % 60000)
                        / 1000;

        return minutes
                + " min "
                + seconds
                + " sec";
    }
}