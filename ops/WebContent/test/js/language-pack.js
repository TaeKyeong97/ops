new Vue({
  el:'#lang-wrap',
  data: {
    langOpen: false,
    products:[]
  },
  created(){
		fetch('json/language-pack.json')
		.then(response => response.json())
		.then(json => {
			this.products=json.products
		})
	}
  ,
})