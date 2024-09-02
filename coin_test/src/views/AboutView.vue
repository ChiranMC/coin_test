<template>
  <div class="about">
    <v-btn style="background-color: blue;
    padding: 2rem;border-radius: 2px;" @click="onSubmit">SayHello</v-btn>
    <br/>
    <h2></h2>
  </div>
</template>


<script setup> 
import axios from 'axios';
import { ref } from 'vue';

const msg = ref('')

const onSubmit = async() => {
  try{
    const response = await axios.get("http://localhost:8082/gethello")
    msg = response.data
    console.log(response.data)
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
