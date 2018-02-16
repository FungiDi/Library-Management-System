package AllInterfaces;

import Entities.Member;

import java.util.List;

public interface MemberInterface {
    boolean add(Member member);

    boolean remove(Member member);

    boolean edit(Member member);

    Member viewByIdObj(Member member);

    List<Member> viewById(Member member);

    List<Member> viewAll(Member member);
}
