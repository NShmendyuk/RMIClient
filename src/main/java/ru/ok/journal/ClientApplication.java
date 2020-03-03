package ru.ok.journal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.ok.journal.remote.entity.RMIComment;
import ru.ok.journal.remote.rmi.IRMIComment;
import ru.ok.journal.remote.rmi.Pair;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
//        SpringApplication.run(ClientApplication.class, args);
//        IRMIComment getRMIComments = SpringApplication.run(ClientApplication.class, args)
//                .getBean(IRMIComment.class);

        ApplicationContext app = SpringApplication.run(ClientApplication.class, args);
        IRMIComment getRMIComments = app.getBean(IRMIComment.class);

        System.out.println("================Client Side ========================");
        Pair pair = new Pair(1,1);
        List<Pair> postIds = new ArrayList<>();
        postIds.add(pair);
        List<RMIComment> comments = getRMIComments.getByPost(postIds);
        System.out.println(comments);
    }
}
