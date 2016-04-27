package com.luyh.projectv1.dao.mapper;

import com.luyh.projectv1.model.Member;
import org.apache.ibatis.annotations.Param;


public interface MemberMapper {

    Member findMemberByUid(@Param("uid") Long uid) throws Exception;

    Member findMemberByMemberId(@Param("employee_id") Integer memberId) throws Exception;

}
