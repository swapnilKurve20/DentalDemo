ALTER TABLE appointment
ADD CONSTRAINT prevent_duplicate_appointment EXCLUDE USING gist
(
  tsrange(start_time, end_time) WITH &&
) WHERE (status != 'Canceled');