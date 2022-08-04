package com.test.experiment.ex.celue0714.export;

import com.test.experiment.ex.celue0714.export.reporttype.BaseReportService;
import com.test.experiment.ex.celue0714.export.reporttype.ReportAService;
import com.test.experiment.ex.celue0714.export.reporttype.ReportBService;
import com.test.experiment.ex.celue0714.export.reporttype.ReportCService;

import java.util.HashMap;
import java.util.Map;

enum ReportTypeEnum {
    A, B, C
}

public class ExportReportByTypeService {
    final static Map<ReportTypeEnum, BaseReportService> serviceMap = new HashMap<>();
    static {
        serviceMap.put(ReportTypeEnum.A, new ReportAService());
        serviceMap.put(ReportTypeEnum.B, new ReportBService());
        serviceMap.put(ReportTypeEnum.C, new ReportCService());
    }

    // @Autowired
    private ReportAService reportAService;
    // @Autowired
    private ReportBService reportBService;
    // @Autowired
    private ReportCService reportCService;
//spring可以注入map，你可以一个接口 三个实现 service上记得命名 然后注入到map里
//    然后你可以直接从map里get名字然后获取service实例
//    serviceMap.get("report"+type.getName()+"Service").exportReport()
    Report run(ReportTypeEnum type) throws Exception {
        switch (type) {
            case A:
                return reportAService.exportReport();
            case B:
                return reportBService.exportReport();
            case C:
                return reportCService.exportReport();
        }
        throw new Exception();
    }

    Report run1(ReportTypeEnum type) throws Exception {
        return serviceMap.get(type).exportReport();
    }

}