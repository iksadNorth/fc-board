<template>
    <div class="mb-1">
        <v-pagination
        v-model="page"
        :length="pages" :total-visible="total_visible"
        rounded="10"
        ></v-pagination>
    </div>
</template>

<script>
export default {
    data() {
        return {
            page: 1,
        }
    },

    watch: {
        'page': function (newVal) {
            this.$emit('page', newVal);
        },
    },

    props: {
        pages: Number,
        total_visible: Number,
    },
}

</script>