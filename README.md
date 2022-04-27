## Dynamic chart Spring Boot Starter

Chart Spring-boot-Starter will help you to create/use/modify charts on websites

###  动态图表总流程

#### 角色

-  总流程中包含三个角色:
1. 前端
2. 应用
3. chart-starter

需要开发的内容即前端和应用角色需要做的事情,其他事情由chart-starter承担

#### 实体

- 总流程中包含三大实体
1. `page` 即页面,可以是整个网页的一部分
2. `card` 即卡片,是`page`中的一个卡片,是图表`chart`的承载者
3. `chart`即图表,其中包含`data`对象,此对象由应用注入



### 流程

**阶段一: 应用初始化阶段**

在此阶段中,可将 `chart-starter`创建的数据导出为sql文件,方便以后导入




1. `应用`使用`chart-starter`的`POST /page-info/create`接口创建`page`和`card`,返回值为整个页面结构

2. `应用`使用`chart-starter`的`POST /create-charts-for-card-by-card-id`接口为特定`card`创建1/N个`chart`,返回值为该`card`拥有的所有`chart`

3. 应用实现`DataInject`接口中的`inject()`方法,并声明为`Spring Bean`,在chart对象中维护该`Bean Name`,``chart-starter``在查询时将调用该`bean`,将数据注入`chart`

   **随着需求的增加,该`DataInject`支持的类型可任意拓展**



由于暂时不做动态图标的前端,阶段一中没有前端角色的参与,应用只需要引入starter,starter将自动建表,之后应用通过接口初始化`page`,`card`,`chart`并实现`bean`将数据结构化,将`beanName`维护到数据库中即可



**阶段二: 前后端使用**



在后端初始化好数据,实现`DataInject`接口为`Spring Bean`之后,前后端即可使用



1. 前端取结构

   前端调用`GET /page-info/page-name/{pageName}`接口,即可取得`page->cards->charts`三级级联数据,此时并不返回`chart data`,担心数据量过大,技术上可以一个接口返回整个页面结构和数据

2. 前端取数据

   前端调用`POST /get-chart-config-data`接口,传入`charts-id`数组,任意查询1个/N个chart数据



### 优势

**后端:**

`chart-starter`将自动建表,暴露接口,应用只需要配置页面信息,注入数据即可

**前端:**

前端的动态图表SDK访问固定的`chart-starter`接口 ,不以应用为转移

**可扩展性:**

`DataInject`注入数据的格式可任意扩展

