# SQL经典练习题目

## 1. 创建表结构及测试数据

### **学生表（student)**

```sql
CREATE TABLE `student` (
  `sid` varchar(10) DEFAULT NULL,
  `sname` varchar(10) DEFAULT NULL,
  `sage` datetime DEFAULT NULL,
  `ssex` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8
```

### **教师表(teacher)**

```sql
CREATE TABLE `teacher` (
  `tid` varchar(10) DEFAULT NULL,
  `tname` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8
```

### **成绩表（sc）**

```sql
CREATE TABLE `sc` (
  `sid` varchar(10) DEFAULT NULL,
  `cid` varchar(10) DEFAULT NULL,
  `score` decimal(18,1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8
```

### **课程表（course）**

```sql
CREATE TABLE `course` (
  `cid` varchar(10) DEFAULT NULL,
  `cname` varchar(10) DEFAULT NULL,
  `tid` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8
```

### 创建测试数据

```sql
# 学生表数据
insert into Student values('01' , '赵雷' , '1990-01-01' , '男');
insert into Student values('02' , '钱电' , '1990-12-21' , '男');
insert into Student values('03' , '孙风' , '1990-05-20' , '男');
insert into Student values('04' , '李云' , '1990-08-06' , '男');
insert into Student values('05' , '周梅' , '1991-12-01' , '女');
insert into Student values('06' , '吴兰' , '1992-03-01' , '女');
insert into Student values('07' , '郑竹' , '1989-07-01' , '女');
insert into Student values('08' , '王菊' , '1990-01-20' , '女');

# 课程表数据
insert into Course values('01' , '语文' , '02');
insert into Course values('02' , '数学' , '01');
insert into Course values('03' , '英语' , '03');


# 教师表数据
insert into Teacher values('01' , '张三');
insert into Teacher values('02' , '李四');
insert into Teacher values('03' , '王五');


# 成绩表数据
insert into SC values('01' , '01' , 80);
insert into SC values('01' , '02' , 90);
insert into SC values('01' , '03' , 99);
insert into SC values('02' , '01' , 70);
insert into SC values('02' , '02' , 60);
insert into SC values('02' , '03' , 80);
insert into SC values('03' , '01' , 80);
insert into SC values('03' , '02' , 80);
insert into SC values('03' , '03' , 80);
insert into SC values('04' , '01' , 50);
insert into SC values('04' , '02' , 30);
insert into SC values('04' , '03' , 20);
insert into SC values('05' , '01' , 76);
insert into SC values('05' , '02' , 87);
insert into SC values('06' , '01' , 31);
insert into SC values('06' , '03' , 34);
insert into SC values('07' , '02' , 89);
insert into SC values('07' , '03' , 98);
```

## 2.SQL题目(1~10)

###  2.1 第一题

> 查询“01”课程比“02”课程成绩高的所有学生的学号；

```sql
select t1.sid
from 
    (select sid,score from sc where cid='01') as t1
join 
    (select sid,score from sc where cid='02') as t2
on t1.sid=t2.sid and t1.score > t2.score
```

### 2.2 第二题

> 查询平均成绩大于60分的同学的学号和平均成绩；

```sql
select sid,avg(score) as avgscore
from sc
group by sid
having avgscore > 60
```

### 2.3 第三题

>查询所有同学的学号、姓名、选课数、总成绩;

```sql
select t1.sid , t1.sname , t2.cnt , t2.total_score
from 
    ( select sid,sname from student group by sid) as t1
join 
    (select sid,count(*) as cnt , sum(score) as total_score from sc group by sid ) as t2
on t1.sid=t2.sid
```

### 2.4 第四题

> 查询姓“李”的老师的个数;

```sql
select count(*) as count
from teacher 
where tname like "李%"
```

### 2.5 第五题

> 查询没学过“张三”老师课的同学的学号、姓名；

```sql
select distinct sid,sname
from student 
where sid not in (
    select sid 
    from sc s
    left join course as c on s.cid =c.cid 
    left join teacher as t on c.tid =t.tid 
    where tname = '张三'
) 
```

### 2.6 第六题

> 查询学过编号“01”并且也学过编号“02”课程的同学的学号、姓名；**（类比题目1）**

```sql
select sid ,sname
from student 
where sid in 
(
   select distinct t1.sid
   from 
     ( select sid,score from sc where cid ='01') as t1
   join 
     ( select sid,score from sc where cid ='02') as t2
   on t1.sid=t2.sid
)
```

### 2.7 第七题

> 查询学过“张三”老师所教的课的同学的学号、姓名；**（类比题目5）**

```sql
select distinct sid,sname
from student 
where sid in (
    select sid 
    from sc s
    left join course as c on s.cid =c.cid 
    left join teacher as t on c.tid =t.tid 
    where tname = '张三'
) 
```

### 2.8 第八题

> 查询课程编号“01”的成绩比课程编号“02”课程低的所有同学的学号、姓名；**（类比题目1和题目6）**

```sql
select sid ,sname
from student 
where sid in 
(
   select distinct t1.sid
   from 
     ( select sid,score from sc where cid ='01') as t1
   join 
     ( select sid,score from sc where cid ='02') as t2
   on t1.sid=t2.sid and t1.score < t2.score
)
```

### 2.9 第九题

> 查询**所有课程**成绩小于60分的同学的学号、姓名；

```sql
select distinct sid ,sname
from student 
where sid in (
    select sid from sc where score<60
)
```

### 2.10 第十题

> 查询没有学全所有课的同学的学号、姓名；

```sql
select s.sid ,s.sname
from student as s
left join sc 
on sc.sid = s.sid 
group by s.sid 
having count(sc.cid ) < 3
```

## 3.SQL题目(11~20)

### 3.1 第十一道

> 查询至少有一门课与学号为“01”的同学所学相同的同学的学号和姓名；

```sql
select distinct sc.sid,sname
from sc
join student as s
on sc.sid=s.sid
where cid in 
          (select distinct cid from sc where sid='01')
```

### 3.2 第十二道

> 查询和"01"号的同学学习的课程完全相同的其他同学的学号和姓名;

```sql

```



### 3.3 第十三道

### 3.4 第十四道

### 3.5 第十五道

### 3.6 第十六道

### 3.7 第十七道

### 3.8 第十八道

### 3.9 第十九道

### 3.10 第二十道



