package FileReading;

public class EmptyFileException extends RuntimeException {//自定义异常，文件为空
    public EmptyFileException(String message) {
        super(message);
    }
}

