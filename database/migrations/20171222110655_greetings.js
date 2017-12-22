exports.up = function(knex) {
  return knex.schema.createTable('greetings', table => {
    table.increments().primary()
    table.string('content').notNullable()
    table.timestamps(true, true)
  })
}

exports.down = function(knex) {
  return knex.schema.dropTable('greetings')
}
