var contactList={currentPage:1,totalNum:0,totalPage:0,ids:new Array(),searchParams:{searchType:_searchType,visible:_visible,ownerUserId:"",offset:0,pageSize:_pageSize,sortField:_sortField,sortOrder:_sortOrder,customerId:""},init:function(){var a=this;entity.initSearchCustomerSelect("search-customerId");entity.initCustomModalButtons();entity.initDeleteEntitiesButton(function(){a.loadContact(a.currentPage)});entity.initToggleAllButton();entity.initSearchItem(a.searchParams,function(){a.loadContact(1)});entity.initTableDragger("entity-list-table");entity.initCustomFields(_targetType,function(){a.loadContact(1)});entity.initPageSizeDropMenu(function(b){a.searchParams.pageSize=b;a.loadContact(1)});importExport.initExportModal(a.searchParams,"contact");importExport.initImportModal("contact");$('#contact-item-list-tab a[data-toggle="tab"]').on("shown.bs.tab",function(b){a.searchParams[$(b.target).data("field")]=$(b.target).data("value");a.loadContact(1)});$("#search-ownerUser").select2({dropdownAutoWidth:true});$("#search-ownerUser").change(function(){a.searchParams.ownerUserId=$(this).val();a.loadContact(1)});$("#search-customerId").change(function(){a.searchParams.customerId=$(this).val();a.loadContact(1)});$(".page-main-container").click(function(b){if($(b.target).closest("td a.item-name").length){return}if($(b.target).closest("table input[type=checkbox]").length){return}$.slidePanel.hide()});entity.initFieldSearch();$("#search-field-form").submit(function(b){entity.setFiledSearchKey(a.searchParams);a.loadContact(1);return false});$("#search-createDate").datepicker({format:"yyyy-mm-dd",autoclose:true,todayBtn:"linked",clearBtn:true}).on("hide",function(b){a.searchParams.startCreateDate=$("#search-startCreateDate").val();a.searchParams.endCreateDate=$("#search-endCreateDate").val();a.loadContact(1)});a.searchParams.ownerUserId=$("#search-ownerUser").val();a.searchParams.startCreateDate=$("#search-startCreateDate").val();a.searchParams.endCreateDate=$("#search-endCreateDate").val();a.loadContact(1)},loadContact:function(a){$("#search-loading").show();$("#item-pageNavi, #contact-blank, #dropdown-menu-pageSize").hide();$("#entity-item-list .list-item").remove();var b=this;b.currentPage=parseInt(a);b.searchParams.offset=(b.currentPage-1)*b.searchParams.pageSize;$.ajax({url:"/contact/list",type:"POST",data:b.searchParams,dataType:"json",timeout:60000,error:function(e,c,d){$("#search-loading").hide();alertify.alert("加载联系人失败，请稍后再试")},success:function(c){$("#search-loading").hide();if(c.code<=0){alertify.alert(c.message);return}if(b.searchParams.offset==0){b.totalNum=c.items.totalNum;b.totalPage=Math.ceil(b.totalNum/b.searchParams.pageSize);$("#exportModal").data("totalnum",b.totalNum)}if(b.totalNum==0){$("#contact-blank").show();return}b.ids.length=0;$.each(c.items.contacts,function(d,e){b.showContactItem(d,e)});entity.loadExtInfo(_showFieldIds,b.ids,"/contact/list/extInfo","contact-item-");$("#item-pageNavi, #dropdown-menu-pageSize").show();createPageNavi(a,b.totalPage,b.totalNum,"item-pageNavi",function(d){b.loadContact(d)})}})},showContactItem:function(a,b){this.ids.push(b.encodedId);var c=$("#contact-item-clone").clone(true).removeClass("hide").addClass("list-item").attr("id","contact-item-"+b.encodedId);c.find(".checkbox-custom input").data("id",b.encodedId);c.find("a.item-name").text(b.name).click(function(d){d.preventDefault();_targetId=b.encodedId;entity.loadSlidePanel("/contact/detail/"+encodeURIComponent(_targetId)+"?isListDetailPage=1")});c.find(".item-duty").text(b.duty);c.find("a.item-customerName").text(b.customerName).attr("href","/customer/detail/"+b.encodedCustomerId);c.find(".item-createDate").text(getFormatDate(b.createDate,"YYYY-MM-DD HH:mm"));c.find(".item-createUser").text(entity.getUserName(entity.getUser(_users,b.encodedCreateUserId)));if(b.encodedLastContactUserId!=""){c.find(".item-lastContactDate").text(getFormatDate(b.lastContactDate,"YYYY-MM-DD HH:mm"));c.find(".item-lastContactUser").text(entity.getUserName(entity.getUser(_users,b.encodedLastContactUserId)))}if(a==-1){c.prependTo($("#contact-body"))}else{c.appendTo($("#contact-body"))}},getContactIdIdx:function(b){for(var a=0;a<this.ids.length;a++){if(this.ids[a]==b){return a}}return -1},navi:function(a){if(a<0){return}if(a>=this.ids.length){return}_targetId=this.ids[a];entity.loadSlidePanel("/contact/detail/"+encodeURIComponent(_targetId)+"?isListDetailPage=1")}};$(function(){contactList.init()});