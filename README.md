# RouteSearch
代码中有一矩阵, 为对应的4*7的点的分布, 1代表节点, 0代表无节点
```
int[][] matrix = {  {1, 1, 1, 0, 1, 0, 1},
                            {1, 1, 1, 0, 1, 0, 1},
                            {0, 1, 1, 0, 0, 1, 1},
                            {1, 1, 1, 1, 1, 1, 0}};
```

将起点和终点确定即可打印出路径
```
        int[] start = {2, 1};
        int[] end = {0, 4};
```
> 2,1->1,1->1,2->1,4->3,4->3,3->3,2->2,2->0,2->0,1->0,0->1,0->3,0->3,1->3,5->2,5->2,6->1,6->0,6->0,4
