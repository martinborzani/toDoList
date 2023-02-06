const app = Vue.createApp({
    data(){
        return{
            personCurrent: {},
            name:"",
            lastname:"",
            notes:[],
            title:"",
            titleEdit: "",

        }
    },
    created(){
        this.loadData();
    },
    mounted(){

    },
    methods: {
        loadData(){
            axios.get('/api/personcurrent')
            .then(response => {
                console.log(response);
                this.personCurrent = response.data;
                console.log(this.personCurrent);
                this.name = this.personCurrent.name;
                this.lastname = this.personCurrent.lastname;
                this.notes = this.personCurrent.notes;
            })
        },

        createNote(){
            axios.post('/api/addnote',"title="+ this.title)
            .then(response =>{
                window.location.href="/web/note.html"
            })

        },

        deleteNote(note){
            axios.post('/api/delete', "id=" + note.id)
            .then(response=>{
                window.location.href="/web/note.html"
            })
            .catch(error =>{
                console.log(error);
            })
        },

        editNote(note){
            axios.post('/api/editnote',"title=" + this.titleEdit + "&id=" + note.id)
            .then(response =>{
                window.location.href="/web/note.html"
            })
            .catch(error =>{
                console.log(error);
            })
        }

    }
}).mount('#app')