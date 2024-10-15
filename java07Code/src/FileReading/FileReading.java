package FileReading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileReading {
    public static String filepath = ".\\src\\FileReading\\data.txt";//用相对路径找data.txt
    public static void main(String[] args) throws Exception{//将异常往上抛出给虚拟机JVM终止程序
        double sum=0,n=0;
        int flag=0;
        findfile();//如果文件不存在，就抛出异常
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(filepath));
        String line;
        try{
            while ((line = br.readLine()) != null) {//读到null就算读完
                int num = Integer.parseInt(line);
                sum += num;
                n+=1;
               // System.out.println(line);
            }
            if(n == 0){
                //n还是0就说明第一行为空，即文件为空
                throw new EmptyFileException("文件为空！！！！");
            }
        }catch(NumberFormatException e){
            //捕获可能出现的NumberFormatException
            flag = 1;//标记出现非数字的字符，则后面不再计算平均值
            System.err.println("NumberFormatException");
            System.err.println("读取到的内容格式错误，包含非数字的字符(有一行空着也算)");

        }
        finally{
            br.close();
            //System.out.println("文件关闭");
        }
        double average = sum/n;
        //System.out.println("sum:"+sum+" n:"+n+" average:"+average);
        if(flag == 0){
            System.out.println("平均值为:"+average);
        }


    }
    public static void findfile() throws Exception{
        File file = new File(filepath);
        if (!file.exists()){
            throw new FileNotFoundException("文件未找到,请检查文件路径是否正确");
        }
    }
}
