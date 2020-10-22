import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

      /*  ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService  executorService =  Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            public void run() {
                System.out.println("ExecutorService");
            }
        });




        //shutting down the executer service
        executorService.shutdown();
*/

       // Example of assigning a task to ExecutorService using invokeAny() method


    ExecutorService executorService = Executors.newSingleThreadExecutor();
        Set<Callable<String>>  callables = new HashSet<Callable<String>>();
        callables.add(new Callable<String>() {
            public String call() throws Exception {
             return "task1";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "task2";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "task3";
            }
        });

        String res = executorService.invokeAny(callables);
        System.out.println(res);

        executorService.shutdown();



    }

    }
