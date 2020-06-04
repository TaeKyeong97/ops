loginCh =new Vue({
  el:'.login',
  data:{
    isChange:true,
    isNoMChange:false
  },
  methods:{
    isChanges:function(){
      this.isChange=false;
      this.isNoMChange=true;
    },
    isNoMChanges:function(){
      this.isChange=true;
      this.isNoMChange=false;
    }
  }
});
