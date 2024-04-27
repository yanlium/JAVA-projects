<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
  <style type="text/css">
    body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
  </style>
  <script type="text/javascript" src="https://api.map.baidu.com/api?type=webgl&v=1.0&ak=nSxiPohfziUaCuONe4ViUP2N"></script>
  <title>地球模式</title>
</head>
<body>
<div id="allmap"></div>
</body>
</html>
<script type="text/javascript">
  // GL版命名空间为BMapGL
  var map = new BMapGL.Map("allmap");    // 创建Map实例
  map.centerAndZoom(new BMapGL.Point(${address}), 17);  // 初始化地图,设置中心点坐标和地图级别,级别越大，地图越贴近地面 17
  map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
  map.setMapType(BMAP_EARTH_MAP);      // 设置地图类型为地球模式
</script>