package FileReading;

class FileNotFoundException extends Exception{
    //自定义异常，文件未找到
    public FileNotFoundException(String message){
        super(message);
    }
}
