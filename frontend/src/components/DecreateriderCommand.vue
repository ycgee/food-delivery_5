<template>

    <v-card outlined>
        <v-card-title>
            Decreaterider
        </v-card-title>

        <v-card-text>
            <Number label="Riderqty" v-model="value.riderqty" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="decreaterider"
            >
                Decreaterider
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'DecreateriderCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.riderqty = 0;
        },
        watch: {
        },
        methods: {
            decreaterider() {
                this.$emit('decreaterider', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

