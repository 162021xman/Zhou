package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import com.example.demo.Bean.Yuyue;
@Mapper
public interface YuyueRepository {

	    @Results(id="YuMap",value= {
	    @Result(property="kid",column="kid",jdbcType=JdbcType.INTEGER),
		@Result(property="kname",column="kname"),
		@Result(property="kphone",column="kphone")
	    })
		@Select("Select * from yuyue")
		public List<Yuyue> getAllYuyue();
	    
	    @Insert("Insert into yuyue(kname,kphone) values(#{kanme},#{kphone})")
	    public int InsertYuyue(@Param("kanme")String kname,@Param("kphone")String kphone);


        @Delete("delete from yuyue where id=#{kid};")
        @ResultMap(value="YuMap")
        public int delpeople(@Param("kid")String kid);
}
