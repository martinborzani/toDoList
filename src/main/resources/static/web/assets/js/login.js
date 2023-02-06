const app = Vue.createApp({
    data(){
        return{

            password:"",
            email:""

        }
    },
    created(){

    },
    mounted(){

    },
    methods:{
        loginAccount(){
            axios.post('/api/login',"email="+ this.email + "&password=" + this.password)
            .then(response =>{
                window.location.href="/web/note.html"
            })
            .catch(error => console.log(error));
        }
    }


}).mount('#app')