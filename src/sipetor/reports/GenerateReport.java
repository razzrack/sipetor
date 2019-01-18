package sipetor.reports;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import sipetor.connection.SQLConnection;
/**
 *
 * @author Rizki
 */

public class GenerateReport {
    private Connection conn = SQLConnection.getConnection();
    
    public void GenerateReportTransaksi(){
        try{
            String sql = "select * from detail_trans_penjualan";
            JasperDesign jd = JRXmlLoader.load("src/sipetor/reports/report1.jrxml");
            JRDesignQuery query = new JRDesignQuery();
            query.setText(sql);
            jd.setQuery(query);
            JasperReport report = JasperCompileManager.compileReport(jd);
            JasperPrint print = JasperFillManager.fillReport(report, null, conn);
            JasperViewer.viewReport(print);
        }
        catch (Exception ex){
            Logger.getLogger(GenerateReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}