package com.z.starter.autoconfig.po;


import com.z.starter.autoconfig.util.DigestUtils;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@ToString(callSuper = true)
@Entity
@Table(name = "plg_judge_white_list")
@Builder
@Data()
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class JudgeWhiteList implements Serializable {
    @Id
    private String id;

    @Column(updatable = false)
    @CreationTimestamp
    private Date createTime;

    @UpdateTimestamp
    private Date updateTime;
    @Column
    private String sourceIp;

    @Column
    private String destinationIp;
    @Column
    private String alarmEventName;

    @Column
    private String alias;
    /**
     * 1 有效
     * 0 无效
     */
    @Column(nullable = false, columnDefinition = "int default 1")
    private Integer validStatus;
    /**
     * 1 永久有效
     * 0 限定时间有效
     */
    @Column(nullable = false, columnDefinition = "int default 1")
    private Integer validType;

    /**
     * yyyy-MM-dd 只计算到天
     */
    @Column
    private Date invalidTime;


    public String initId() {
        if (destinationIp == null ||"".equals(destinationIp)) {
            id =  DigestUtils.md5Hex(sourceIp + alarmEventName);
        } else {

            id = DigestUtils.md5Hex(sourceIp + alarmEventName + destinationIp);
        }
        return id;
    }

}
