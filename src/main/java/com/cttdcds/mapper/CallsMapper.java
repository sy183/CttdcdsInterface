package com.cttdcds.mapper;

import com.cttdcds.pojo.Call;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CallsMapper {
	List<Call> getCalls();
}
