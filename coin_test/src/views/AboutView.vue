<template>
  <div class="about">
    <v-btn style="background-color: blue;cursor: pointer;
    padding: 2rem;border-radius: 2px;" @click="onSubmit">SayHello</v-btn>
    <br/>
   <div style="margin-top: 3rem;"> 
    <h2 style="color: aliceblue;">{{ msg }}</h2>
   </div>
  </div>
</template>


<script setup> 
import axios from 'axios';
import { ref } from 'vue';

const msg = ref('')

const onSubmit = async() => {
  try{
    const response = await axios.get("http://localhost:8082/gethello")
    if(response.status === 200){
      msg.value = "Hello from backend!"
    }
  }catch(err){
    console.log(err)
  }
}
</script>

<style>
@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>
