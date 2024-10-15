class InsufficientFundsException extends Exception {//继承自Exception，所以该异常必须处理才能抛出成功
    public InsufficientFundsException(String message) {//构造器
        super(message);//自定义异常，传入想输出的异常信息。
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;//传入账户的初始余额
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        //因为自定义的InsufficientFundsException是编译的异常，需要抛出给上一层或者捕获处理，所以要throws
        if (amount > balance) {
            throw new InsufficientFundsException("余额不足，无法取款。当前余额: " + balance);
            //如果钱不够就抛出InsufficientFundsException到调用该方法的位置,内容是"余额不足，无法取款。当前余额: " + balance
        }
        balance -= amount;
        //如果够钱就减去取出的钱；
    }
}

public class BankAccountExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(Math.random()*200);
        //随机生成一个0~200的数作为账户的初始余额
        try {
            System.out.println("当前余额: " + account.getBalance());
            account.withdraw(150.0);//取150元，进入withdraw方法
            //如果withdraw方法抛出异常，那么就不会执行下面取款成功的语句，直接被捕获（进入catch语句）
            //如果没有抛出异常，那么输出取款成功，跳过catch语句，输出程序结束。
            System.out.println("取款成功。");
        } catch (InsufficientFundsException e) {//实例化一个InsufficientFundsException对象捕获withdraw的异常,并输出错误的信息
            System.err.println("错误: " + e.getMessage());
            //e.getMessage()就是访问上面传入的message;
            //奇怪的问题：如果把err换成out,那么程序结束就最后输出，但是如果是err，那么是错误的信息最后输出。
        }

        System.out.println("程序结束");
    }
}