<template>
  <div class="hello">
    <h1>Enter the coordiantes and hit go button</h1>
    <input :v-model="lat" placeholder="latitude" />
    <input :v-model="lng" placeholder="longitude" />
    <input :v-model="radius" placeholder="radius" />
    <button @click="find">Find nearest locations</button>
    <GMapMap :center="center" :zoom="10" map-type-id="terrain" style="width: 500px; height: 300px">
      <GMapMarker :key="index" v-for="(marker, index) in markers" :position="marker.location"/>
    </GMapMap>
  </div>
</template>

<script>

export default {
  name: 'MapView',
  props: {},
  data: () => ({
    markers: [],
    center: {
      lat: 40.9903,
      lng: 29.0205
    },
    lat: 40.9903,
    lng: 29.0205,
    radius: 10000
  }),
  methods: {
    async find() {
      const url = `${process.env.VUE_APP_CODEXIST_BE_URL}/codexist-places/places?lat=${this.lat}&lng=${this.lng}&radius=${this.radius}` // maybe this can replaced with axios
      this.markers = (await (await fetch(url)).json()).places.map((p) => p.geometry)
      this.center = { lat: this.lat, lng: this.lng }
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
