(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-11537f12"],{"117f":function(t,e,n){},"2cf0":function(t,e,n){"use strict";n.r(e);var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"tagEntity"},[n("div",{staticClass:"left"},[n("el-card",{staticClass:"box-card"},[n("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[n("span",[t._v("第"+t._s(t.textIndex)+"句")])]),n("div",{staticClass:"text item",nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.addTag()}}},[t._v(t._s(t.textarea))])]),n("div",{staticClass:"button"},[t.isEdit?t._e():n("el-button",{attrs:{type:"primary",size:"small"},on:{click:function(e){return t.addTag()}}},[t._v("添加标签")]),t.isEdit?t._e():n("el-button",{attrs:{type:"success",size:"small"},on:{click:function(e){return t.saveTag()}}},[t._v("保存标记")]),t.isEdit?n("el-button",{attrs:{type:"success",size:"small"},on:{click:function(e){return t.editTag()}}},[t._v("修改标记")]):t._e(),t.isEdit||0==t.dynamicTags.length?t._e():n("el-button",{attrs:{type:"danger",size:"small"},on:{click:function(e){return t.deleteAllTag()}}},[t._v("删除所有标签")]),t.isQuitEdit?n("el-button",{attrs:{type:"warning",size:"small"},on:{click:function(e){return t.quitEditTag()}}},[t._v("取消修改")]):t._e(),n("el-button",{attrs:{type:"primary",icon:"el-icon-arrow-left",size:"small",disabled:t.isFirst},on:{click:function(e){return t.turnTo(1,t.isShowAll)}}},[t._v("上一句")]),n("el-button",{attrs:{type:"primary",size:"small",disabled:t.isLast},on:{click:function(e){return t.turnTo(2,t.isShowAll)}}},[t._v("下一句"),n("i",{staticClass:"el-icon-arrow-right el-icon--right"})])],1),n("div",{staticClass:"tagarea"},t._l(t.dynamicTags,(function(e,a){return n("el-tag",{key:a,attrs:{closable:!t.isEdit,"disable-transitions":!1},on:{close:function(n){return t.handleClose(e.content,a)}}},[t._v("\n                "+t._s(e.content)+" ("+t._s(e.startIdx)+","+t._s(e.endIdx)+")\n            ")])})),1)],1),n("div",{staticClass:"right"},[n("el-row",[n("el-col",{attrs:{span:24}},[n("el-card",{attrs:{shadow:"always"}},[n("el-dropdown",{on:{command:t.handleCommandShow}},[n("span",{staticClass:"el-dropdown-link"},[t._v("\n                    选择显示内容"),n("i",{staticClass:"el-icon-arrow-down el-icon--right"})]),n("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[n("el-dropdown-item",{attrs:{command:"1"}},[t._v("显示全部句子")]),n("el-dropdown-item",{attrs:{command:"0"}},[t._v("显示未标记句子")]),n("el-dropdown-item",{attrs:{disabled:""}},[t._v("默认显示未标记句子")])],1)],1),t.isShowAll?n("p",[t._v("当前：显示全部句子")]):t._e(),t.isShowAll?t._e():n("p",[t._v("当前：显示未标记句子")]),n("el-divider"),n("el-dropdown",{on:{command:t.handleCommandDelete}},[n("span",{staticClass:"el-dropdown-link"},[t._v("\n                    选择删除标签的方式"),n("i",{staticClass:"el-icon-arrow-down el-icon--right"})]),n("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[n("el-dropdown-item",{attrs:{command:"0"}},[t._v("仅在该句中删除标签")]),n("el-dropdown-item",{attrs:{command:"1"}},[t._v("在所有句子中删除该标签")]),n("el-dropdown-item",{attrs:{disabled:""}},[t._v("默认在所有句子中删除该标签")])],1)],1),t.isDeleteinAll?n("p",[t._v("当前：在所有句子中删除该标签")]):t._e(),t.isDeleteinAll?t._e():n("p",[t._v("当前：仅在该句中删除标签")])],1)],1)],1)],1)])},s=[],i=(n("ac6a"),n("5df3"),n("6b54"),n("96cf"),n("3b8d")),r=n("6234"),c={data:function(){return{textIndex:"",textareaId:"",textarea:"",dynamicTags:[],dynamicTagsPre:[],dynamicTagsNow:[],isEdit:!1,isFirst:!1,isLast:!1,isShowAll:0,isDeleteinAll:1,isQuitEdit:!1}},mounted:function(){this.setTextarea(),this.$store.commit("setActiveIndex",1);var t=this;window.addEventListener("keypress",(function(e){108==e.which&&t.addTag(1)}))},methods:{setTextarea:function(){var t=Object(i["a"])(regeneratorRuntime.mark((function t(){var e,n,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(!this.$store.state.content){t.next=10;break}return this.textarea=this.$store.state.content,this.textIndex=this.$store.state.index,t.next=5,Object(r["g"])({content:this.textarea});case 5:e=t.sent,this.textareaId=e.data,this.$store.state.isMark&&(this.isEdit=this.$store.state.isMark),t.next=15;break;case 10:return t.next=12,Object(r["n"])();case 12:n=t.sent,this.textarea=n.data[0].content,this.textareaId=n.data[0].id;case 15:return t.next=17,Object(r["h"])({id:this.textareaId});case 17:return a=t.sent,this.textIndex=a.data,t.next=21,this.preTag();case 21:this.judgeFirstandLast();case 22:case"end":return t.stop()}}),t,this)})));function e(){return t.apply(this,arguments)}return e}(),judgeFirstandLast:function(){var t=Object(i["a"])(regeneratorRuntime.mark((function t(){var e,n;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,Object(r["o"])({id:this.textareaId,is_marked:this.isShowAll});case 2:return e=t.sent,t.next=5,Object(r["p"])({id:this.textareaId,is_marked:this.isShowAll});case 5:n=t.sent,0==e.data?this.isFirst=!0:this.isFirst=!1,0==n.data?this.isLast=!0:this.isLast=!1;case 8:case"end":return t.stop()}}),t,this)})));function e(){return t.apply(this,arguments)}return e}(),preTag:function(){var t=Object(i["a"])(regeneratorRuntime.mark((function t(){var e,n=this;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return this.dynamicTags=[],this.dynamicTagsPre=[],this.dynamicTagsNow=[],t.next=5,Object(r["k"])();case 5:e=t.sent,e.data.map((function(t){for(var e=0;-1!=n.textarea.indexOf(t.content,e);){var a=n.textarea.indexOf(t.content,e),s=a+t.length;e=s+1;var i=[];i={content:t.content,startIdx:a,endIdx:s,id:t.id},n.dynamicTagsPre.push(i)}})),this.dynamicTags=this.dynamicTags.concat(this.dynamicTagsPre);case 8:case"end":return t.stop()}}),t,this)})));function e(){return t.apply(this,arguments)}return e}(),addTag:function(){var t=Object(i["a"])(regeneratorRuntime.mark((function t(e){var n,a,s,c,o,d,u,l,h,m,f,g,p,x=this;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(window.console.log(1),1!=e){t.next=5;break}this.$confirm("确认添加标签？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(Object(i["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:x.addTag();case 1:case"end":return t.stop()}}),t)})))).catch((function(){x.$message({type:"info",message:"已取消删除"})})),t.next=45;break;case 5:if(window.getSelection?n=window.getSelection():window.document.getSelection?n=window.document.getSelection():window.document.selection&&(n=window.document.selection.createRange().text),a=n.toString(),s=Math.min(n.anchorOffset,n.focusOffset),c=Math.max(n.anchorOffset,n.focusOffset),o=c-s,d=[],u=[],l=[],""!=a&&null!=a){t.next=17;break}this.$message({type:"info",message:"选中内容为空！"}),t.next=45;break;case 17:if(0!=this.dynamicTagsPre.length&&this.dynamicTagsPre.map((function(t){d.push(t.content)})),0!=this.dynamicTagsNow.length&&this.dynamicTagsNow.map((function(t){u.push(t.content),l.push(t.startIdx)})),h=[],-1!=d.indexOf(a)){t.next=44;break}if(m=u.indexOf(a),f=l[m],-1!=m){t.next=32;break}return t.next=26,Object(r["q"])({content:a,length:o});case 26:g=t.sent,h={content:a,startIdx:s,endIdx:c,id:g.data},this.dynamicTagsNow.push(h),this.dynamicTags.push(h),t.next=42;break;case 32:if(f==s){t.next=41;break}return t.next=35,Object(r["f"])({content:a});case 35:p=t.sent,h={content:a,startIdx:s,endIdx:c,id:p.data},this.dynamicTagsNow.push(h),this.dynamicTags.push(h),t.next=42;break;case 41:this.$message({type:"info",message:"该实体已被标记，请勿重复标记"});case 42:t.next=45;break;case 44:this.$message({type:"info",message:"该实体已被预标记，请勿重复标记"});case 45:case"end":return t.stop()}}),t,this)})));function e(e){return t.apply(this,arguments)}return e}(),handleClose:function(t,e){var n=this;this.$confirm("此操作将永久删除该标签, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(Object(i["a"])(regeneratorRuntime.mark((function a(){var s,i;return regeneratorRuntime.wrap((function(a){while(1)switch(a.prev=a.next){case 0:if(1!=n.isDeleteinAll){a.next=7;break}return a.next=3,Object(r["a"])({content:t});case 3:return s=a.sent,i=s.data,a.next=7,Object(r["b"])({id_entity:i});case 7:n.dynamicTags.splice(e,1),n.$message({type:"success",message:"删除成功!"});case 9:case"end":return a.stop()}}),a)})))).catch((function(){n.$message({type:"info",message:"已取消删除"})}))},deleteAllTag:function(){var t=this;this.$confirm("确定要删除该句子的所有标记？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(Object(i["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,Promise.all(t.dynamicTags.map(function(){var e=Object(i["a"])(regeneratorRuntime.mark((function e(n){var a,s;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(1!=t.isDeleteinAll){e.next=7;break}return e.next=3,Object(r["a"])({content:n.content});case 3:return a=e.sent,s=a.data,e.next=7,Object(r["b"])({id_entity:s});case 7:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}()));case 2:return e.next=4,Object(r["c"])({id_sentence:t.textareaId});case 4:return t.isEdit=!1,t.isQuitEdit=!1,t.dynamicTags=[],t.dynamicTagsPre=[],t.dynamicTagsNow=[],e.next=11,Object(r["u"])({id:t.textareaId,is_marked:0});case 11:case"end":return e.stop()}}),e)})))).catch((function(){t.$message({type:"info",message:"已取消删除"})}))},saveTag:function(){var t=this;0==this.dynamicTags.length?this.$message({type:"warning",message:"该句子未被标记，无法保存标记！"}):this.$confirm("确定要保存标记？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(Object(i["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,Object(r["c"])({id_sentence:t.textareaId});case 2:t.dynamicTags.map((function(e){Object(r["r"])({id_sentence:t.textareaId,id_entity:e.id,start_index:e.startIdx,end_index:e.endIdx})})),Object(r["u"])({id:t.textareaId,is_marked:1}),t.isQuitEdit=!1,t.isEdit=!0,t.isLast?t.$message({type:"success",message:"保存成功！已是最后一句！"}):t.$message({type:"success",message:"保存成功！"});case 7:case"end":return e.stop()}}),e)})))).catch((function(){t.$message({type:"info",message:"已取消保存"})}))},editTag:function(){var t=Object(i["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return this.isEdit=!1,this.isQuitEdit=!0,t.next=4,this.preTag();case 4:this.judgeFirstandLast();case 5:case"end":return t.stop()}}),t,this)})));function e(){return t.apply(this,arguments)}return e}(),quitEditTag:function(){this.isEdit=!0,this.isQuitEdit=!1,this.$message({type:"info",message:"已取消修改"})},handleCommandDelete:function(t){this.isDeleteinAll=1==t?1:0},handleCommandShow:function(t){this.isShowAll=1==t?1:0,this.judgeFirstandLast()},turnTo:function(){var t=Object(i["a"])(regeneratorRuntime.mark((function t(e,n){var a,s,i;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(a=[],1!=e){t.next=7;break}return t.next=4,Object(r["o"])({id:this.textareaId,is_marked:n});case 4:a=t.sent,t.next=11;break;case 7:if(2!=e){t.next=11;break}return t.next=10,Object(r["p"])({id:this.textareaId,is_marked:n});case 10:a=t.sent;case 11:return s=a.data[0],0==s.is_marked?this.isEdit=!1:this.isEdit=!0,this.textarea=s.content,this.textareaId=s.id,t.next=17,Object(r["h"])({id:this.textareaId});case 17:i=t.sent,this.textIndex=i.data,this.preTag(),this.judgeFirstandLast();case 21:case"end":return t.stop()}}),t,this)})));function e(e,n){return t.apply(this,arguments)}return e}()}},o=c,d=(n("4a7b"),n("2877")),u=Object(d["a"])(o,a,s,!1,null,"c7bb46de",null);e["default"]=u.exports},3846:function(t,e,n){n("9e1e")&&"g"!=/./g.flags&&n("86cc").f(RegExp.prototype,"flags",{configurable:!0,get:n("0bfb")})},"4a7b":function(t,e,n){"use strict";var a=n("117f"),s=n.n(a);s.a},"6b54":function(t,e,n){"use strict";n("3846");var a=n("cb7c"),s=n("0bfb"),i=n("9e1e"),r="toString",c=/./[r],o=function(t){n("2aba")(RegExp.prototype,r,t,!0)};n("79e5")((function(){return"/a/b"!=c.call({source:"a",flags:"b"})}))?o((function(){var t=a(this);return"/".concat(t.source,"/","flags"in t?t.flags:!i&&t instanceof RegExp?s.call(t):void 0)})):c.name!=r&&o((function(){return c.call(this)}))}}]);