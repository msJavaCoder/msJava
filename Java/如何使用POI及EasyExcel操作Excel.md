# 如何使用POI及EasyExcel操作Excel

## 1. POI

+ 导入依赖

```xml
            <!--03--> 
           <dependency>
                <groupId>org.apache.poi</groupId>
                <artifactId>poi</artifactId>
                <version>3.9</version>
            </dependency>
            <!--07--> 
            <dependency>
                <groupId>org.apache.poi</groupId>
                <artifactId>poi-ooxml</artifactId>
                <version>3.9</version>
            </dependency>
```

+ 写入Excel _Demo

```java
public class ExcelWriteTest {
    String PATH="F:\\easyExcel";
    @Test
    public void test() throws IOException {
        long begin=System.currentTimeMillis();
        //1.创建一个工作薄  
        Workbook workbook=new HSSFWorkbook();  //2003 xls文件    优点：运行效率高，缺点：存储记录不多63359条
        //Workbook workbook=new XSSFWorkbook();//2007 xlsX文件  可以存储更多记录，缺点就是比03慢、消耗内存，也会发生溢出，比如100万条  升级版可以使用 Workbook workbook=new SXSSFWorkbook();   xlsX文件  
        //2.创建一个工作表
        Sheet sheet=workbook.createSheet();
        for (int rowNum = 0; rowNum < 65536; rowNum++) {
            //3.创建行
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum <10 ; cellNum++) {
                //4.创建列
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        System.out.println("生成完成");
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "xxx.xls");
        workbook.write(fileOutputStream);
        //关闭流
        fileOutputStream.close();
        //清楚临时文件
        ((SXSSFWorkbook) workbook).dispose();
        long end=System.currentTimeMillis();
        //运行时间
        System.out.println((double) (end-begin)/1000);
    }
}
```

