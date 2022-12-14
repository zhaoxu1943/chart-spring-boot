## Dynamic chart Spring Boot Starter

Chart Spring-boot-Starter will help you to create/use/modify charts on websites

### 如何增加一种chart类型?(方法论 at v0.0.6)(实践 at v0.0.9)
方法论:
1. 确认该chart类型模型是否和现有chart类型兼容?
模型包括:和Chart基类相比多出哪些独有属性,DataInject的数据类型
如果现有数据类型不能支持
2. 在ChartType枚举类中,添加新的类型,为新的类型建立一套创建接口(controller-service-repository)
3. 建立实体类extends Chart,并声明其独有属性
4. 建立注入数据实体类extends BaseData,并描述其注入的数据类型
5. 在Card中建立该类型背包(List),VOMapUtil添加到CardVO:charts的转换即可
6. 在getChartConfigDataByChartQuery中配置新的类型的注入
目前只有step-5涉及修改已有类型Card

实践:
需求中需要添加一种结构,它有着一个图形,一些key-value值组成,此图形也可以看作Map中一个属性
1. 与现有的Chart基类有结构上的区别吗?
没有,现在CHART模块也并无基础CHART的实现,所以在此称之为`NORMAL_CHART`
2. 有适合的Data注入基类吗?
没有,需要增加Map注入类

故操作方式:
1. 在`ChartType.java`中增加`NORMAL_CHART`,为新的类型建立一套创建接口(controller-service-repository)
2. 结构创建:创建`NormalChart extends Chart`,但无额外属性
3. 数据注入创建: 创建`NormalChartData extends BaseData`,创建Map型数据
4. 在Card中建立该类型背包`List<NormalChart> normalCharts`,并处理Card与CardVO的转换
5. 在getChartConfigDataByChartQuery中配置新的类型的注入
6. 完善新的单元测试

测试后: 该类型提供了一个chart基类,没有额外属性的chart都可以用该Normal_chart来承载,
它没有额外结构属性,但同样可以接收queryMap
比如时间控件,也可以使用它承载

### UPDATE LOG
- 2022年06月10日 version 0.0.11
`NormalTable`独有属性`List<NormalTableColumn>`,即字段配置列表中,
添加属性`columnWidth` 列宽

修改:
1.后端如果预置了NormalTable配置,sql可能需要修改一下
2.前后端需要协商下`columnWidth`单位,现在仅是一个Integer类型数字



- 2022年05月27日 version 0.0.10
各类chart统一修改:
1. 将 chartQuery对象改为 Map<String,Object>,可传数组
普通图表(NORMAL_CHART)修改:
2. 将注入数据类型改为 List<Map<String,Object>>,即map列表


- 2022年05月25日 version 0.0.9
1. 增加新的类型`NORMAL_CHART`,对应Data注入结构:`Map`适配以下几种图表
- 它没有独特的结构属性,仅作为一个抽象性图表的载体,向后端传queryMap,后端响应Map供前端显示
- 插件的载体,同样无独特的结构属性,只需要生成如时间信息,放置到多个queryMap中实现图表联动


- 2022年05月20日 version 0.0.8
1. 完善单元测试,覆盖率:88% classes, 70% lines (jacoco report)
2. 增加全局异常处理,全局返回值处理

应用后端无修改
前端修改:
1. `page-info/page-name/{name}` 接口增加Result封装,之前漏掉了
2. `page-info/page-name/{name}` 接口中cards数组不再含有无关属性

BUG修复:
1. 不再会使主应用启动时打印true了



- 2022年05月16日 version 0.0.7
1. 将page和card 改为N:N关系
2. 现在可以创建空的page(无card关联),供数据库配置N:N关系


- 2022年05月07日 version 0.0.6
1. 依据OCP,将代码重构

原因: 两类图表BAR,NORMAL_TABLE的独有属性(x,y轴,普通图表的表头)杂糅在chart实体中,如果出现第三种图表将更难以扩展

修改内容:

后端:

1.将为card创建chart一分为二,去掉原来的统一添加接口,变为
create-bars-for-card-by-card-id与create-normal-tables-for-card-by-card-id,
即根据CardID创建bars集合与根据CardID创建normal-table集合,创建完成如json结构所示
单一的card中将拥有多个集合,以后出现第N种类型后,添加一个新的集合即可
该card可以显示的chart为所有种类chart集合的并集

Req create-normal-tables-for-card-by-card-id
```json
[{
		"type": "NORMAL_TABLE",
		"title": "testTitle",
		"beanName": "testNormal1",
		"normalTableColumnConfigList": [{
				"columnKey": "name",
				"columnChineseName": "姓名"
			},
			{
				"columnKey": "age",
				"columnChineseName": "年龄"
			}

		]

	}

]
```

Req create-bars-for-card-by-card-id

```json
[{
		"type": "BAR",
		"title": "testTitle",
		"beanName": "testBar1",
		"xaxisName" :"xxx",
        "yaxisName" :"yyy"

	}

]
```


```json
{
   "id": 1,
   "createTime": "2022-05-07T08:00:16.526+00:00",
   "updateTime": "2022-05-07T08:00:16.526+00:00",
   "numberOfCutPage": null,
   "name": "alarm3",
   "cards": [
      {
         "id": 1,
         "createTime": "2022-05-07T08:00:16.490+00:00",
         "updateTime": "2022-05-07T08:35:26.538+00:00",
         "defaultChartType": null,
         "defaultChartId": null,
         "title": null,
         "cardOrder": null,
         "span": 5,
         "cardOffset": 1,
         "bars": null,
         "normalTables": null,
         "charts": [
            {
               "id": 2,
               "createTime": "2022-05-07T08:35:26.528+00:00",
               "updateTime": "2022-05-07T08:35:26.528+00:00",
               "title": "testTitle",
               "type": "BAR",
               "beanName": "testBar1",
               "data": null,
               "xaxisName": "xxx",
               "yaxisName": "yyy"
            },
            {
               "id": 3,
               "createTime": "2022-05-07T08:14:05.165+00:00",
               "updateTime": "2022-05-07T08:14:05.197+00:00",
               "title": "testTitle",
               "type": "NORMAL_TABLE",
               "beanName": "testNormal1",
               "data": null,
               "normalTableColumnConfigList": [
                  {
                     "id": 3,
                     "createTime": "2022-05-07T08:14:05.173+00:00",
                     "updateTime": "2022-05-07T08:14:05.173+00:00",
                     "columnKey": "name",
                     "columnChineseName": "姓名",
                     "columnEnglishName": null,
                     "hide": false,
                     "sortable": false,
                     "sortDirection": null,
                     "columnOrder": null
                  },
                  {
                     "id": 4,
                     "createTime": "2022-05-07T08:14:05.182+00:00",
                     "updateTime": "2022-05-07T08:14:05.182+00:00",
                     "columnKey": "age",
                     "columnChineseName": "年龄",
                     "columnEnglishName": null,
                     "hide": false,
                     "sortable": false,
                     "sortDirection": null,
                     "columnOrder": null
                  }
               ]
            }
         ]
      },
      {
         "id": 2,
         "createTime": "2022-05-07T08:00:16.506+00:00",
         "updateTime": "2022-05-07T08:00:16.506+00:00",
         "defaultChartType": null,
         "defaultChartId": null,
         "title": null,
         "cardOrder": null,
         "span": 5,
         "cardOffset": 1,
         "bars": null,
         "normalTables": null,
         "charts": []
      },
      {
         "id": 3,
         "createTime": "2022-05-07T08:00:16.513+00:00",
         "updateTime": "2022-05-07T08:00:16.513+00:00",
         "defaultChartType": null,
         "defaultChartId": null,
         "title": null,
         "cardOrder": null,
         "span": 5,
         "cardOffset": 1,
         "bars": null,
         "normalTables": null,
         "charts": []
      }
   ]
}
```

2. 相应的将BaseData的继承拆分为BarData和NormalTableData,注入例子见ChartDataConfig
3. 实体修改,chart对象不以实体存在,作为chart类实体的抽象存在,维护chart的共有属性,如title,data等

前端使用:

上述配置均由后端初始化好即可,前端使用区别:chart的获取

1. default chart 的获取
之前仅靠ID获取card的default chart,现在需要后端同时维护好default chart的 chartType,供前端使用

2. chart data-config的获取
chartType为必传,当然返回值也会分的很清,BAR除了基础属性只有xy轴,TABLE除了基础属性只有表头
除此之外,data中也分清了,bar只有维度list,而table只有对象list
```json

[

{
    "id": 1,
    "chartType":"BAR"
},
{
    "id": 3,
    "chartType":"NORMAL_TABLE"
}

]
```

```json
{
    "code": 200,
    "message": "SUCCESS",
    "data": [
        {
            "id": 1,
            "createTime": "2022-05-07T08:13:41.233+00:00",
            "updateTime": "2022-05-07T08:13:41.233+00:00",
            "title": "testTitle",
            "type": "BAR",
            "beanName": "testBar1",
            "data": {
                "dimensionList": [
                    {
                        "name": "DNS",
                        "xyaxisList": [
                            {
                                "name": "10.1.1.1",
                                "value": "22"
                            },
                            {
                                "name": "10.1.1.2",
                                "value": "122"
                            },
                            {
                                "name": "10.1.1.3",
                                "value": "222"
                            },
                            {
                                "name": "10.1.1.4",
                                "value": "222"
                            }
                        ]
                    },
                    {
                        "name": "HTTP",
                        "xyaxisList": [
                            {
                                "name": "10.1.1.1",
                                "value": "221"
                            },
                            {
                                "name": "10.1.1.2",
                                "value": "122"
                            },
                            {
                                "name": "10.1.1.3",
                                "value": "222"
                            },
                            {
                                "name": "10.1.1.4",
                                "value": "222"
                            }
                        ]
                    }
                ]
            },
            "xaxisName": null,
            "yaxisName": null
        },
        {
            "id": 3,
            "createTime": "2022-05-07T08:14:05.165+00:00",
            "updateTime": "2022-05-07T08:14:05.197+00:00",
            "title": "testTitle",
            "type": "NORMAL_TABLE",
            "beanName": "testNormal1",
            "data": {
                "normalTableObjectList": [
                    {
                        "name": "张三",
                        "age": 2
                    },
                    {
                        "name": "李五",
                        "age": 20
                    }
                ]
            },
            "normalTableColumnConfigList": [
                {
                    "id": 3,
                    "createTime": "2022-05-07T08:14:05.173+00:00",
                    "updateTime": "2022-05-07T08:14:05.173+00:00",
                    "columnKey": "name",
                    "columnChineseName": "姓名",
                    "columnEnglishName": null,
                    "hide": false,
                    "sortable": false,
                    "sortDirection": null,
                    "columnOrder": null
                },
                {
                    "id": 4,
                    "createTime": "2022-05-07T08:14:05.182+00:00",
                    "updateTime": "2022-05-07T08:14:05.182+00:00",
                    "columnKey": "age",
                    "columnChineseName": "年龄",
                    "columnEnglishName": null,
                    "hide": false,
                    "sortable": false,
                    "sortDirection": null,
                    "columnOrder": null
                }
            ]
        }
    ]
}
```





-----
- 2022年05月06日 version 0.0.5
1. 支持NORMAL TABLE,客户端例子见ChartDataConfig#testChartData5
2. 增加配置接口 `create-normal-table-column-config-by-chart-id` 通过chart-id 增加NORMAL_TABLE 的字段配置
3. //todo 重构代码,增加类型扩展性,目前不符合开放封闭原则

- 2022年05月02日 version 0.0.3
1. 文件夹结构调整,实体更名,使更容易理解
2. 将DataInject接口重构为函数式接口,其中的inject方法升级为带参数的数据注入方法
3. 提供BaseData类,作为数据注入的基础模板类
4. 支持多chart联动:在chart-data接口中请求N个联动链表的chartQuery数组,应用按参数查询即可

- 2022年04月30日 version 0.0.2
实现chart基础功能,包括
1. 自动创建表结构功能
2. 提供基础配置的创建API
3. 提供DataInject接口,应用去实现注入数据功能
4. 获取配置,获取数据API

- 2022年04月25日 version 0.0.1
chart思路讨论
完成chart-spring-boot骨架搭建



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

