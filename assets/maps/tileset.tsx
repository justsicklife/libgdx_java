<?xml version="1.0" encoding="UTF-8"?>
<tileset version="1.10" tiledversion="1.11.2" name="tileset" tilewidth="16" tileheight="16" spacing="16" margin="8" tilecount="192" columns="12">
 <image source="tileset.png" width="384" height="512"/>
 <tile id="1">
  <objectgroup draworder="index" id="2">
   <object id="1" x="0.125" y="6.375">
    <polygon points="0,0 16.125,-0.125 16.25,6.75 -0.5,6.5"/>
   </object>
  </objectgroup>
 </tile>
 <tile id="2">
  <objectgroup draworder="index" id="2">
   <object id="1" x="0" y="7">
    <polygon points="0,0 0.125,5.875 4.5,8.875 11.375,8.875"/>
   </object>
  </objectgroup>
 </tile>
 <tile id="8">
  <animation>
   <frame tileid="8" duration="200"/>
   <frame tileid="9" duration="200"/>
   <frame tileid="10" duration="200"/>
   <frame tileid="11" duration="200"/>
  </animation>
 </tile>
 <wangsets>
  <wangset name="Unnamed Set" type="corner" tile="-1">
   <wangcolor name="grass" color="#ff0000" tile="-1" probability="1"/>
   <wangcolor name="cliff" color="#00ff00" tile="-1" probability="1"/>
   <wangtile tileid="0" wangid="0,1,0,2,0,1,0,1"/>
   <wangtile tileid="1" wangid="0,1,0,2,0,2,0,1"/>
   <wangtile tileid="2" wangid="0,1,0,1,0,2,0,1"/>
   <wangtile tileid="12" wangid="0,2,0,2,0,1,0,1"/>
   <wangtile tileid="14" wangid="0,1,0,1,0,2,0,2"/>
   <wangtile tileid="24" wangid="0,2,0,1,0,1,0,1"/>
   <wangtile tileid="25" wangid="0,2,0,1,0,1,0,2"/>
   <wangtile tileid="26" wangid="0,1,0,1,0,1,0,2"/>
   <wangtile tileid="36" wangid="0,2,0,2,0,2,0,1"/>
   <wangtile tileid="37" wangid="0,1,0,2,0,2,0,2"/>
   <wangtile tileid="48" wangid="0,2,0,2,0,1,0,2"/>
   <wangtile tileid="49" wangid="0,2,0,1,0,2,0,2"/>
   <wangtile tileid="181" wangid="0,1,0,1,0,1,0,1"/>
  </wangset>
 </wangsets>
</tileset>
