package com.zhsnail.esdata.etl.controller;

import com.example.esdata.core.web.web.Result;
import com.ververica.cdc.connectors.mysql.source.MySqlSource;
import com.ververica.cdc.debezium.JsonDebeziumDeserializationSchema;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhongzhaohai
 * @date 2023/6/16 16:57
 */
@RestController
@RequestMapping("/test")
@ControllerAdvice
public class TestController {

    @GetMapping("/testResult")
    public Result<Void> test(){
        return new Result<>();
    }

    public static void main(String[] args) throws Exception {
        MySqlSource<String> mySqlSource = MySqlSource.<String>builder()
                .hostname("localhost")
                .port(3501)
                .databaseList("test") // 设置捕获的数据库， 如果需要同步整个数据库，请将 tableList 设置为 ".*".
                .tableList(".*") // 设置捕获的表
                .username("root")
                .password("123456")
                .deserializer(new JsonDebeziumDeserializationSchema()) // 将 SourceRecord 转换为 JSON 字符串
                .build();
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // enable checkpoint
        env.enableCheckpointing(3000);


        env.fromSource(mySqlSource, WatermarkStrategy.noWatermarks(), "MySQL Source")
                // 设置 source 节点的并行度为 4
                .setParallelism(4)
                .print().setParallelism(1); // 设置 sink 节点并行度为 1

        env.execute("Print MySQL Snapshot + Binlog");
    }
}
