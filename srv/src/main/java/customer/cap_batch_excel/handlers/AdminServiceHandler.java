package customer.cap_batch_excel.handlers;

import org.springframework.stereotype.Component;
import customer.cap_batch_excel.upload.NoModelDataListener;
import com.sap.cds.services.cds.CdsUpdateEventContext;
import com.sap.cds.services.cds.CqnService;

import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.ServiceName;
import com.sap.cds.services.persistence.PersistenceService;
import com.sap.cds.services.handler.annotations.On;
import cds.gen.adminservice.Upload;
import cds.gen.adminservice.Upload_;
import java.io.InputStream;
import java.util.Arrays;
import com.alibaba.excel.EasyExcel;

@Component
@ServiceName("AdminService")
public class AdminServiceHandler implements EventHandler {

    private final PersistenceService db;

    AdminServiceHandler(PersistenceService db) {
        this.db = db;
    }

    @On(entity = Upload_.CDS_NAME, event = CqnService.EVENT_READ)
    public Upload getUploadSingleton() {
        return Upload.create();
    }

    @On
    public void handle_excel(CdsUpdateEventContext context, Upload upload) {
        InputStream is = upload.getProducts();
        if (is != null) {
           //  EasyExcel.read(is, Products.class, new ProductListener()).sheet().doRead();
           EasyExcel.read(is, new NoModelDataListener(db)).sheet().doRead();
        };
      context.setResult(Arrays.asList(upload));
    }

}
